import makeFilterCitiesWorker from 'workerize!./filter-cities'
// fancy webpack loader to wrap a module in a webworker

const {getItems} = makeFilterCitiesWorker()

export {getItems}

/*
eslint
  import/no-webpack-loader-syntax: 0,
*/
