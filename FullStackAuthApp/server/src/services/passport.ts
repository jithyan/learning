import passport from "passport";
import User, { IUser } from "../models/user";
import { secret } from "../config";
import {
  Strategy,
  ExtractJwt,
  VerifiedCallback,
  StrategyOptions
} from "passport-jwt";
import {
  Strategy as LocalStrategy,
  IStrategyOptionsWithRequest,
  VerifyFunctionWithRequest,
  VerifyFunction,
  IStrategyOptions
} from "passport-local";
import { IJwt } from "../controllers/authentication";

// setup options for jet strategy
const jwtOptions: StrategyOptions = {
  jwtFromRequest: ExtractJwt.fromHeader("authorization"),
  secretOrKey: secret
};

//Create JWT strategy
const jwtLogin = new Strategy(jwtOptions, function(
  payload: IJwt,
  done: VerifiedCallback
) {
  User.findById(payload.sub, function(err: any, user: IUser) {
    if (err) {
      done(null, user);
    } else {
      done(null, false);
    }
  });
});

//local strategy
const localOptions: IStrategyOptions = { usernameField: "email" };
const localLogin = new LocalStrategy(localOptions, (email, password, done) => {
  //veorfy this is the correct u + p, call done with the user
  // otherwise call done with false
  User.findOne({ email }, function(err, user) {
    if (err) {
      return done(err);
    }
    if (!user) {
      return done(null, false);
    }

    user.comparePassword(password, (err, isMatch) => {
      if (err) {
        return done(err);
      } else if (!isMatch) {
        return done(null, false);
      } else {
        return done(null, user);
      }
    });
  });
});

// Tell passport to use this strategy
export const jwtStrategy = passport.use(jwtLogin);
export const localStrategy = passport.use(localLogin);
