import { ApolloServer, gql } from "apollo-server-express";
import express from "express";
import mongoose from "mongoose";
import session from "express-session";
import passport from "passport";
import { Strategy as LocalStrategy } from "passport-local";
import helmet from "helmet";
import ms from "connect-mongo";
import typeDefs from "./schema/types";
import { User } from "./models/user";
import bodyParser from "body-parser";

const MongoStore = ms(session);

const MONGO_URI =
  "mongodb+srv://moody:dogbas@cluster0.tmihm.mongodb.net/auth?retryWrites=true&w=majority";

// Mongoose's built in promise library is deprecated, replace it with ES2015 Promise
mongoose.Promise = global.Promise;

// Connect to the mongoDB instance and log a message
// on success or failure
mongoose.connect(MONGO_URI, {
  useUnifiedTopology: true,
  useNewUrlParser: true,
});
mongoose.connection
  .once("open", () => console.log("Connected to MongoLab instance."))
  .on("error", (error) => console.log("Error connecting to MongoLab:", error));

// Resolvers define the technique for fetching the types defined in the
// schema.
const resolvers = {
  Mutation: {
    signup: (
      parent: any,
      args: { email: string; password: string },
      context: any,
      info: any
    ) => {
      console.log("context", context);
      return signup({
        email: args.email,
        password: args.password,
        req: context,
      });
    },
  },
};

const app = express();

//app.use(helmet());
// Configures express to use sessions.  This places an encrypted identifier
// on the users cookie.  When a user makes a request, this middleware examines
// the cookie and modifies the request object to indicate which user made the request
// The cookie itself only contains the id of a session; more data about the session
// is stored inside of MongoDB.
app.use(
  session({
    resave: true,
    saveUninitialized: true,
    secret: "aaabbbccc",
    store: new MongoStore({
      url: MONGO_URI,
      autoReconnect: true,
    }),
  })
);

app.use(bodyParser.urlencoded({ extended: false }));

// SerializeUser is used to provide some identifying token that can be saved
// in the users session.  We traditionally use the 'ID' for this.
passport.serializeUser((user: any, done) => {
  done(null, user.id);
});

// The counterpart of 'serializeUser'.  Given only a user's ID, we must return
// the user object.  This object is placed on 'req.user'.
passport.deserializeUser((id, done) => {
  User.findById(id, (err, user) => {
    done(err, user);
  });
});

// Creates a new user account.  We first check to see if a user already exists
// with this email address to avoid making multiple accounts with identical addresses
// If it does not, we save the existing user.  After the user is created, it is
// provided to the 'req.logIn' function.  This is apart of Passport JS.
// Notice the Promise created in the second 'then' statement.  This is done
// because Passport only supports callbacks, while GraphQL only supports promises
// for async code!  Awkward!
export function signup({ email, password, req }: any) {
  const user = new User({ email, password });
  if (!email || !password) {
    throw new Error("You must provide an email and password.");
  }

  return User.findOne({ email })
    .then((existingUser) => {
      if (existingUser) {
        throw new Error("Email in use");
      }
      return user.save();
    })
    .then((user) => {
      return new Promise((resolve, reject) => {
        req.logIn(user, (err: any) => {
          if (err) {
            reject(err);
          }
          resolve(user);
        });
      });
    });
}

// Logs in a user.  This will invoke the 'local-strategy' defined above in this
// file. Notice the strange method signature here: the 'passport.authenticate'
// function returns a function, as its indended to be used as a middleware with
// Express.  We have another compatibility layer here to make it work nicely with
// GraphQL, as GraphQL always expects to see a promise for handling async code.
export function login({ email, password, req }: any) {
  return new Promise((resolve, reject) => {
    passport.authenticate("local", (err, user) => {
      if (!user) {
        reject("Invalid credentials.");
      }

      req.login(user, () => resolve(user));
    })({ body: { email, password } });
  });
}

// Instructs Passport how to authenticate a user using a locally saved email
// and password combination.  This strategy is called whenever a user attempts to
// log in.  We first find the user model in MongoDB that matches the submitted email,
// then check to see if the provided password matches the saved password. There
// are two obvious failure points here: the email might not exist in our DB or
// the password might not match the saved one.  In either case, we call the 'done'
// callback, including a string that messages why the authentication process failed.
// This string is provided back to the GraphQL client.
passport.use(
  new LocalStrategy({ usernameField: "email" }, (email, password, done) => {
    User.findOne({ email: email.toLowerCase() }, (err, user: any) => {
      if (err) {
        return done(err);
      }
      if (!user) {
        return done(null, false, { message: "Invalid Credentials" });
      }
      user.comparePassword(password, (err: any, isMatch: any) => {
        if (err) {
          return done(err);
        }
        if (isMatch) {
          return done(null, user);
        }
        return done(null, false, { message: "Invalid Credentials" });
      });
    });
  })
);

// Passport is wired into express as a middleware. When a request comes in,
// Passport will examine the request's session (as set by the above config) and
// assign the current user to the 'req.user' object.  See also servces/auth.js
app.use(passport.initialize());
app.use(passport.session());

// The ApolloServer constructor requires two parameters: your schema
// definition and your set of resolvers.
const server = new ApolloServer({
  typeDefs,
  resolvers,
  context: ({ req }: any) => {
    return {
      logIn: req.logIn,
    };
  },
});

server.applyMiddleware({ app, path: "/graphql" });

// Replace with your mongoLab URI

// The `listen` method launches a web server.
app.listen({ port: 4000 }, () =>
  console.log(`🚀 Server ready at http://localhost:4000${server.graphqlPath}`)
);
