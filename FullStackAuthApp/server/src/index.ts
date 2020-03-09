import express from "express";
import morgan from "morgan";
import helmet from "helmet";
import bodyParser from "body-parser";
import mongoose from "mongoose";

import { route } from "./router";

mongoose
  .connect("mongodb://localhost:27017/auth", {
    useNewUrlParser: true,
    useUnifiedTopology: true
  })
  .catch(error => console.log(`Failed with error ${error}`));

const app = express();
app.use(helmet());
app.use(morgan("combined")); // this is a logging framework
app.use(bodyParser.json({ type: "*/*" })); // This particular type syntax means parse any request as JSON - not good for prod servers!
route(app);

const port = process.env.PORT || 3090;

app.listen(port, () => console.log(`Listening on port ${port}`));
