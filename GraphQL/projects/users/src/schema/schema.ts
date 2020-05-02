import {
  GraphQLObjectType,
  GraphQLSchema,
  GraphQLString,
  GraphQLInt,
} from "graphql";
import { find } from "lodash";
/**
 * The purpose of the schema is to instruct GraphQL on
 * what type of data we have in the application and the relationships between them.
 */

/**
 * Describe the data type of a User.
 * Two REQUIRED properties:
 *   - name (string) convention is pascal case
 *  - fields
 */
const UserType = new GraphQLObjectType({
  name: "User",
  fields: {
    id: { type: GraphQLString },
    firstName: { type: GraphQLString },
    age: { type: GraphQLInt },
  },
});

const users = [
  { id: "23", firstName: "Bill", age: 23 },
  { id: "47", firstName: "Angela", age: 26 },
];

/**
 * Each GraphQL query needs a RootQuery - it serves as an entry point into a graph
 *
 * This particular query translates to:
 * IF you 're looking for a user, and you give me an "id", I will return you a UserType
 *
 * The resolve function is used to actually return data from your datastore
 * It is the most important property!
 * However "parentValue" is almost never used!
 */

const RootQuery = new GraphQLObjectType({
  name: "RootQueryType",
  fields: {
    user: {
      type: UserType,
      args: { id: { type: GraphQLString } },
      resolve: (parentValue, args) => find(users, { id: args.id }),
    },
  },
});

export default new GraphQLSchema({ query: RootQuery });
