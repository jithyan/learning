import React from "react";
import {
  addMessageMutation,
  messagesQuery,
  messageAddedSubscription,
} from "./graphql/queries";
import MessageInput from "./MessageInput";
import MessageList from "./MessageList";
import { useQuery, useMutation, useSubscription } from "@apollo/react-hooks";

function useChatMessagesWithApolloReactHooks() {
  const { loading, data } = useQuery(messagesQuery);
  const messages = data ? data.messages : [];
  // The second argument is another way of accessing the mutation data, but with a lot more useful properties
  // It also has a prop called 'loading' and 'data', which we can't destructure because of the above line
  const [addMessage, { error, called }] = useMutation(addMessageMutation);

  const result = useSubscription(messageAddedSubscription, {
    // Rather than locally managing the state of messages, in this technique
    // we rely on Apollo's internal cache.
    // The `useQuery` will write data to the cache and return it once the graphql
    // is complete - but it will also return updated data if we update its cache directly -> which is what we do below:
    // The beauty of this is that the data is shared across all components that accesses `messages` !
    // How do we know Apollo's cache stores it in an object called `messages`? From the messagesQuery!
    onSubscriptionData: ({ client, subscriptionData }) => {
      client.writeData({
        data: {
          messages: messages.concat(subscriptionData.data.messageAdded),
        },
      });
    },
  });

  return { messages, addMessage };
}

function Chat({ user }) {
  const { messages, addMessage } = useChatMessagesWithApolloReactHooks();

  const handleSend = async (text) => {
    // This returns an objectt with data (which we don't use as we have a subscription)
    const { data } = await addMessage({ variables: { input: { text } } });
  };

  return (
    <section className="section">
      <div className="container">
        <h1 className="title">Chatting as {user}</h1>
        <MessageList user={user} messages={messages} />
        <MessageInput onSend={handleSend} />
      </div>
    </section>
  );
}

export default Chat;
