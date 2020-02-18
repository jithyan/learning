import './index.css';
import Card from './Card';
import React from 'react';
import data from '../data/data.json'
import {bindActionCreators} from 'redux';
import {initStore, initialCards, addItem} from '../store';
import withRedux from 'next-redux-wrapper';
import {connect} from 'react-redux';


class Index extends React.Component {

   //How you get data in SSR
   static async getInitialProps({store}) {
      //return { cards: data };
      store.dispatch(initialCards());
   }

   render() {
      return (
         <div>
            <header>
               <img src="/static/logo.png"
                  className="static-logo"
                  alt="logo" />
            </header>

            <div className="Grid">
               {this.props.cards.map((card) => <Card key={card.id} />)}
            </div>
         </div>
      );
   }
};

const mapDispatchToProps = (dispatch) => {
   return {
      initialCards: bindActionCreators(initialCards, dispatch),
      addItem: bindActionCreators(addItem, dispatch)
   }
}

const mapStateToProps = (state) => {
   return {
      cards: state.cards
   }
}

export default connect(mapStateToProps, mapDispatchToProps)(Index);