import React, { Component } from "react";
import { getLoggedInUser, logout } from "./auth";
import Chat from "./Chat";
import Login from "./Login";
import NavBar from "./NavBar";
import { ApolloProvider } from "@apollo/react-hooks";
import client from "./graphql/client";

class App extends Component {
  state = { user: getLoggedInUser() };

  handleLogin(user) {
    this.setState({ user });
  }

  handleLogout() {
    logout();
    this.setState({ user: null });
  }

  render() {
    const { user } = this.state;
    if (!user) {
      return <Login onLogin={this.handleLogin.bind(this)} />;
    }
    // ApolloProvider is needed when you use Apollo React Hooks
    return (
      <ApolloProvider client={client}>
        <NavBar onLogout={this.handleLogout.bind(this)} />
        <Chat user={user} />
      </ApolloProvider>
    );
  }
}

/**
 * We need to install apollo-link-ws and subscriptions-transport-ws
 */

export default App;
