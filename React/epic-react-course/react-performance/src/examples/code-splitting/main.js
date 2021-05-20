// http://localhost:3000/isolated/examples/code-splitting/main.js

import * as React from 'react'

/**
 * ! Note that all this stuff has implications if you're using SSR!
 */

// https://webpack.js.org/api/module-methods/#magic-comments

/**
 * the webpackChunkName magic comment which will allow webpack to place common modules in the same chunk.
 * This is good for components which you want loaded together in the same chunk
 * (to reduce multiple requests for multiple modules which will likely be needed together).
 */
const DepsIncluded = React.lazy(() =>
  import(/* webpackChunkName: "deps" */ './deps-included'),
)
const One = React.lazy(() =>
  import(/* webpackChunkName: "group" */ './group/one'),
)
const Two = React.lazy(() =>
  import(/* webpackChunkName: "group" */ './group/two'),
)

// For reqular modules, just use `webpackMode: "lazy"`

/**
 * With this, the browser will automatically load this JavaScript file into the browser cache
 * so it’s ready ahead of time.
 *
 * Prefetched chunks are:
 * 1. loaded AFTER the parent chunk is loaded
 * 2. how low priority - will be downloaded when the browser is idle
 * 3. Used to indicate to the browser that the module will be needed in future navigation
 */
const Prefetched = React.lazy(() =>
  import(
    /* webpackPrefetch: true */
    /* webpackChunkName: "prefetched" */
    './prefetched'
  ),
)

/**
 * Preloaded chunks are:
 * 1. Medium priority - is instantly downloaded.
 * 2. Downloaded in PARALLEL to the parent chunk.
 * 3. Indicates to the browser the module is required in current navigation
 */
const Preloaded = React.lazy(() =>
  import(
    /* webpackPreload: true */
    /* webpackChunkName: "preload" */
    './preloaded'
  ),
)

function Main() {
  const [show, setShow] = React.useState(false)
  return (
    <React.Suspense fallback="...">
      <button onClick={() => setShow(true)}>Show</button>
      {show ? (
        <div>
          <DepsIncluded />
          <One />
          <Two />
          <Prefetched />
          <Preloaded />
        </div>
      ) : null}
    </React.Suspense>
  )
}

export default Main
