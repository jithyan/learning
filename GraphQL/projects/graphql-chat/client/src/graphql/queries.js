import gql from "graphql-tag";
import client from "./client";

export const messagesQuery = gql`
  query MessagesQuery {
    messages {
      id
      from
      text
    }
  }
`;

export const messageAddedSubscription = gql`
  subscription {
    messageAdded {
      id
      from
      text
    }
  }
`;

export const addMessageMutation = gql`
  mutation AddMessageMutation($input: MessageInput!) {
    message: addMessage(input: $input) {
      id
      from
      text
    }
  }
`;

export async function addMessage(text) {
  const { data } = await client.mutate({
    mutation: addMessageMutation,
    variables: { input: { text } },
  });
  return data.message;
}

export async function getMessages() {
  const { data } = await client.query({ query: messagesQuery });
  return data.messages;
}

export function onMessageAdded(handleMessage) {
  //initialize a subscription on the server
  const observable = client.subscribe({ query: messageAddedSubscription });
  // subscribe to the observable. Multiple UI components should subscribe to this. Ideally, the first step should be in a different function
  return observable.subscribe(({ data }) => handleMessage(data.messageAdded));
}
