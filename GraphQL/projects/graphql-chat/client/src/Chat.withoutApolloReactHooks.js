import React, { useState, useEffect } from "react";
import { addMessage, getMessages, onMessageAdded } from "./graphql/queries";
import MessageInput from "./MessageInput";
import MessageList from "./MessageList";

function useChatMessages() {
  const [messages, setMessages] = useState([]);

  useEffect(() => {
    getMessages().then((value) => setMessages(value));
  }, []);

  useEffect(() => {
    const subscription = onMessageAdded((message) =>
      setMessages((prevMessages) => prevMessages.concat(message))
    );

    return () => subscription.unsubscribe();
  }, []);

  return messages;
}

function Chat({ user }) {
  const messages = useChatMessages();

  return (
    <section className="section">
      <div className="container">
        <h1 className="title">Chatting as {user}</h1>
        <MessageList user={user} messages={messages} />
        <MessageInput onSend={(text) => addMessage(text)} />
      </div>
    </section>
  );
}

export default Chat;
