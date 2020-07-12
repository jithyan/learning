import express from "express";
//import models from "./models";
import expressGraphQL from "express-graphql";
import mongoose from "mongoose";
import bodyParser from "body-parser";
import schema from "./schema/schema";

const app = express();

// Replace with your mongoLab URI
const MONGO_URI =
  "mongodb+srv://moody:Dogbiscuit12!@cluster0-tmihm.mongodb.net/test?retryWrites=true&w=majority";
if (!MONGO_URI) {
  throw new Error("You must provide a MongoLab URI");
}

mongoose.Promise = global.Promise;
mongoose.connect(MONGO_URI);
mongoose.connection
  .once("open", () => console.log("Connected to MongoLab instance."))
  .on("error", (error) => console.log("Error connecting to MongoLab:", error));

app.use(bodyParser.json());
app.use(
  "/graphql",
  expressGraphQL({
    schema,
    graphiql: true,
  })
);

export default app;
