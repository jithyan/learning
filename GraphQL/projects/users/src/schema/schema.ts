import {
  GraphQLObjectType,
  GraphQLSchema,
  GraphQLString,
  GraphQLInt,
  GraphQLList,
  GraphQLNonNull,
} from "graphql";
import { find } from "lodash";
import axios from "axios";
import { response } from "express";

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

// To deal with circular references,. wrap the field with a closure.

const CompanyType: any = new GraphQLObjectType({
  name: "Company",
  fields: () => ({
    id: { type: GraphQLString },
    name: { type: GraphQLString },
    description: { type: GraphQLString },
    users: {
      type: new GraphQLList(UserType),
      resolve: (parentValue, args) =>
        axios
          .get(`http://localhost:3000/companies/${parentValue.id}/users`)
          .then((res) => res.data),
    },
  }),
});

// In order to establish the relationship between User and Company, you need to  do it
// via the resolve function. The `parentValue` is the current user object.
const UserType = new GraphQLObjectType({
  name: "User",
  fields: {
    id: { type: GraphQLString },
    firstName: { type: GraphQLString },
    age: { type: GraphQLInt },
    company: {
      type: CompanyType,
      resolve: (parentValue, args) =>
        axios
          .get(`http://localhost:3000/companies/${parentValue.companyId}`)
          .then((res) => res.data),
    },
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
      resolve: (parentValue, args) =>
        axios
          .get(`http://localhost:3000/users/${args.id}`)
          .then((resp) => resp.data),
    },
    company: {
      type: CompanyType,
      args: { id: { type: GraphQLString } },
      resolve: (parentValue, args) =>
        axios
          .get(`http://localhost:3000/companies/${args.id}`)
          .then((resp) => resp.data),
    },
  },
});

//mutations
const mutation = new GraphQLObjectType({
  name: "Mutation",
  fields: {
    addUser: {
      type: UserType,
      args: {
        firstName: { type: new GraphQLNonNull(GraphQLString) },
        age: { type: new GraphQLNonNull(GraphQLInt) },
        companyId: { type: GraphQLString },
      },
      resolve: (parentValue, args) => {
        return axios
          .post(`http://localhost:3000/users/`, {
            firstName: args.firstName,
            age: args.age,
          })
          .then((res) => res.data);
      },
    },
    deleteUser: {
      type: GraphQLString,
      args: {
        id: { type: new GraphQLNonNull(GraphQLString) },
      },
      resolve: (parentValue, args) =>
        axios
          .delete(`http://localhost:3000/users/${args.id}`)
          .then((resp) => "success"),
    },
    editUser: {
      type: UserType,
      args: {
        id: { type: new GraphQLNonNull(GraphQLString) },
        firstName: { type: GraphQLString },
        companyId: { type: GraphQLString },
      },
      resolve: (parentValue, args) =>
        axios
          .patch(`http://localhost:3000/users/${args.id}`, args)
          .then((resp) => resp.data),
    },
  },
});

export default new GraphQLSchema({ query: RootQuery, mutation });
