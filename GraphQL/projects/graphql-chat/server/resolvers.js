const db = require("./db");
const { PubSub } = require("graphql-subscriptions");
// We need to import PubSub from graphql-subscriptions and pass it to the resolver.
const pubSub = new PubSub();

const MESSAGE_ADDED = "MESSAGE_ADDED";

function requireAuth(userId) {
  if (!userId) {
    throw new Error("Unauthorized");
  }
}

const Query = {
  messages: (_root, _args, { userId }) => {
    requireAuth(userId);
    return db.messages.list();
  },
};

const Mutation = {
  addMessage: (_root, { input }, { userId }) => {
    requireAuth(userId);
    const messageId = db.messages.create({ from: userId, text: input.text });
    const message = db.messages.get(messageId);
    // we send an event when a message gets added
    pubSub.publish(MESSAGE_ADDED, { messageAdded: message });
    return db.messages.get(messageId);
  },
};

// Unlike mutations and resolvers, we pass in a object with the subscription
// name and give it a subscribe function.
//  The asyncIterator takes an event name as an argument
const Subscription = {
  messageAdded: {
    subscribe: (_root, _args, { userId }) => {
      // See server.js! We had to do extra work to get the user from context
      requireAuth(userId);
      return pubSub.asyncIterator(MESSAGE_ADDED);
    },
  },
};

module.exports = { Query, Mutation, Subscription };
