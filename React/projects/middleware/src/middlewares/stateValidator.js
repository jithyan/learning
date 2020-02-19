import tv4 from "tv4";
import stateSchema from "./stateSchema";

export default ({ dispatch, getState }) => next => action => {
  next(action); // We want to run this middleware AFTER the reducer has been updated and all our other middleware has run!
  console.log(tv4.validate(getState(), stateSchema));
};
