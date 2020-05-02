import express from "express";
import schema from "./schema/schema";
// expressGraphQL is middleware
// note - graphQL is typically written as GraphQL
import expressGraphQL from "express-graphql";

const app = express();
const port = 4000;

app.use(
  "/graphql",
  expressGraphQL({
    schema,
    graphiql: true,
  })
);

app.listen(port, () => {
  console.log(`listening on port ${port}`);
});
