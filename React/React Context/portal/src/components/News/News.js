import React, { Component } from 'react';
import NewSingle from './NewSingle';
import Error from './Error';
import { ThemeConsumer } from '../App';

class News extends Component {
  constructor(props) {
    super(props);
    this.state = {
      news: [],
      error: false,
    };
  }

  componentDidMount() {
    const url = `https://newsapi.org/v2/${this.props.news.type}?${this.props.news.query}&apiKey=537034265f2f4885a9dd72e0ef35323d`;

    fetch(url)
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        this.setState({
          news: data.articles
        })
      })
      .catch((error) => {
        this.setState({
          error: true
        })
      });
  }

  renderItems() {
    if (!this.state.error) {
      //Ideally ThemeConsumer should be outside the return, so it'd be returned only once. Since this is an exercise, it's skipped.
      return this.state.news.map((item) => (
        <ThemeConsumer>
          {({ styles }) => (
            <div style={styles}>
              <NewSingle key={item.url} item={item} />
            </div>
          )}
        </ThemeConsumer>
      ));
    } else {
      return <Error />
    }
  }

  render() {
    return (
      <div className="row">
        {this.renderItems()}
      </div>
    );
  }
}

export default News;
