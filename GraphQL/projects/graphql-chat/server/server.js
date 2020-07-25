const fs = require("fs");
const { ApolloServer } = require("apollo-server-express");
const bodyParser = require("body-parser");
const cors = require("cors");
const express = require("express");
const expressJwt = require("express-jwt");
const jwt = require("jsonwebtoken");
const db = require("./db");
const http = require("http");

const port = 9000;
// The secret unique to the server for verifying tokens
const jwtSecret = Buffer.from("xkMBdsE+P6242Z2dPV3RD91BPbLIko7t", "base64");

const app = express();
app.use(
  cors(),
  bodyParser.json(),
  expressJwt({
    credentialsRequired: false,
    secret: jwtSecret,
  })
);

const typeDefs = fs.readFileSync("./schema.graphql", { encoding: "utf8" });
const resolvers = require("./resolvers");

function context(params) {
  // There are two connectiosn - one HTTP and one WS coming from the client
  // when HTTP -> req is present. When WS, params is {connection, payload}
  const { req, connection } = params;

  if (req && req.user) {
    return { userId: req.user.sub }; //req.user.sub is set automatically express-jwt
  } else if (connection) {
    //we need to decode the JWT ourselves
    const decodedToken = jwt.verify(connection.context.accessToken, jwtSecret);
    return { userId: decodedToken.sub };
  }
  return {};
}

const apolloServer = new ApolloServer({ typeDefs, resolvers, context });
apolloServer.applyMiddleware({ app, path: "/graphql" });

// With an existing HTTP server (created with createServer), we can add subscriptions using the installSubscriptionHandlers.
const httpServer = http.createServer(app);
// Add subscription handlers - enable websocksets for graphql
apolloServer.installSubscriptionHandlers(httpServer);

app.post("/login", (req, res) => {
  const { name, password } = req.body;
  const user = db.users.get(name);
  if (!(user && user.password === password)) {
    res.sendStatus(401);
    return;
  }
  const token = jwt.sign({ sub: user.id }, jwtSecret);
  res.send({ token });
});

// Pay attention to the fact that we are calling `listen` on the http server variable,
httpServer.listen(port, () => console.log(`Server started on port ${port}`));
