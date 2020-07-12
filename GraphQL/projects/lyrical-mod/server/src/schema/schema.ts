import _ from "lodash";
import { GraphQLSchema } from "graphql";

const RootQueryType = require("./root_query_type");
const mutations = require("./mutations");

export default new GraphQLSchema({
  query: RootQueryType,
  mutation: mutations,
});
