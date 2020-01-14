import express, { Request, Response } from "express";
import bodyParser from "body-parser";
import cookieSession from "cookie-session";

import { router } from "./routes/loginRouter";

const app = express();

app.use(bodyParser.urlencoded({ extended: true }));
app.use(cookieSession({ keys: ["randomstring"] }));
app.use(router);

/*
app.get("/", (req: Request, res: Response) => {
  res.send(`
    <div>
        <h1>Hi there</h1>
    </div>
    `);
});
*/

app.listen(3000, () => {
  console.log("listening on port 3000");
});
