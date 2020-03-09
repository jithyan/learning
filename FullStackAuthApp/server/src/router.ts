import { Request, Response, NextFunction, Express } from "express";
import { signup, signin } from "./controllers/authentication";
import { jwtStrategy, localStrategy } from "./services/passport";
import passport from "passport";

//by default, passport does a cookie-based session, which we DONT want.
const requireAuth = jwtStrategy.authenticate("jwt", { session: false });
const requireSigin = localStrategy.authenticate("local", { session: false });

export function route(app: Express) {
  app.get("/", requireAuth, function(
    req: Request,
    res: Response,
    next: NextFunction
  ) {
    res.send({ body: "str" });
  });

  app.post("/signin", requireSigin, signin);
  app.post("/signup", signup);
}
