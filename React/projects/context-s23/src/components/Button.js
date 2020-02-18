import React from 'react';

import LanguageContext from '../context/LanguageContext';
import ColorContext from '../context/ColorContext';

class Button extends React.Component {
   //static contextType = LanguageContext; //contextType is a special property name!
   //static is your regular static meaning in Java (i.e. it's independent of a class instance)

   renderButton = (color) => {
      return (<button className={`ui button ${color}`}>
         <LanguageContext.Consumer>
            {(value) => value === 'english' ? 'Submit' : 'Voorleggen'}
         </LanguageContext.Consumer>
      </button>);
   }

   render() {
      //const text = this.context === 'english' ? 'Submit' : 'Voorleggen';
      //A consumer component takes a function that takes in a value from the context
      //This class demonstrates using Consumer approach to accessing Context
      return (
         <ColorContext.Consumer>
            {(colorValue) => this.renderButton(colorValue)}
         </ColorContext.Consumer>

      );
   }
}

export default Button;