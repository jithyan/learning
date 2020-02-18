import React, { Component } from 'react';
import './App.css';
import News from './News/News';

const UserData = React.createContext(); //You can pass in a default value here (optional)
const Theme = React.createContext();

export const UserConsumer = UserData.Consumer;
export const ThemeConsumer = Theme.Consumer;

class App extends Component {
  constructor(props) {
    super(props);

    //We're using this to update the context
    this.toggleName = () => {
      this.setState(state => ({
        name: state.name === 'Manny Henri' ? 'Somebody Else' : 'Manny Henri'
      }))
    }

    this.state = {
      news: {
        type: 'everything',
        query: 'domains=techcrunch.com&language=en'
      },
      name: 'Manny Henri',
      toggleName: this.toggleName,
      style: {
        display: 'flex'
      }
    };
  }

  render() {
    //It's best not to pass down fixed values from the top level Provider context, as it may cause all
    // components to re-render. If you pass this.state, then only the components whose state has changed
    // will be re-rendered. So keep this in mind, for performance reasons.
    return (
      <UserData.Provider value={this.state}>
        <div className="containwer-fluid">
          <div className="navbar-fixed">
            <nav>
              <div className="nav-wrapper indigo lighten-4">
                <a href="/" className="bran-logo center">My Feed</a>
              </div>
            </nav>
          </div>
          <div className="row">
            <div className="col s12">
              <Theme.Provider value={this.state}>
                <News news={this.state.news} />
              </Theme.Provider>
            </div>
          </div>
        </div>
      </UserData.Provider>
    );
  }
}

export default App;
