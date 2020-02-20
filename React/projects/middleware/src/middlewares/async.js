// The author of redux decided to put the signature of redux like this.
// A function that returns a function that returns a function is the standard boiler plate.

/*
export default function({ dispatch }) {
  return function(next) {
    //"next" is a reference to the next middleware in the chain
    return function(action) {
      //"action" is the object sent with your action - it has the type and possible payload
    };
  };
}
*/

export default ({ dispatch }) => next => action => {
  // check to see if the action has a promise on its payload property
  // if it does, wait for it to resolve
  // if it doesn't, then send the action to the next middleware

  if (!action.payload || !action.payload.then) {
    return next(action); //We're not returning anything - it's to ensure the function terminates!
  }

  action.payload.then(function(response) {
    const newAction = { ...action };
    dispatch(newAction); //By dispatching it, we start the cycle again
  });
};
