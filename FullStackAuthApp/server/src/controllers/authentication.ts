import { NextFunction, Request, Response } from "express";
import jwt from "jwt-simple";

import { secret } from "../config";
import User, { IUser } from "../models/user";
import { stringify } from "querystring";

export interface IJwt {
  sub: string;
  iat: number;
}
// We encode an object with a secret
// The object must contain some user identifying information.
// By convention, we use the property 'sub', which means subject
function tokenForUser(user: IUser) {
  return jwt.encode({ sub: user.id, iat: new Date().getTime() }, secret);
}

export function signup(req: Request, res: Response, next: NextFunction) {
  const email = req.body.email;
  const password = req.body.password;

  if (!email || !password) {
    return res.status(400).send({ error: "User name or password is missing" });
  }

  // See if a user with a given email exists
  // The second argument is a callback with an error, and the result
  User.findOne({ email: email }, (error, existingUser) => {
    if (error) {
      return next(error);
    }

    //IF a user does exist, send an error because you can't signup an exsiting user
    // HTTP 422 means "Unprocessable Entity"
    // It means while the server understood the request content and there were no syntax errors,
    // the server was not able to process it.
    if (existingUser) {
      return res.status(422).send({ error: "E-mail is in use" });
    }

    // IF a user with an e-mail does NOT exist, create and save record
    const user = new User({ email, password });
    user.save(error => {
      if (error) {
        return next(error);
      } else {
        return res.json({ token: tokenForUser((user as unknown) as IUser) });
      }
    });
  });
}

export function signin(req: Request, res: Response, next: NextFunction) {
  //user already has the detail authenticated
  if (req.user) {
    res.send({ token: tokenForUser(req.user as any) });
  } else {
    res.sendStatus(500);
  }
}
