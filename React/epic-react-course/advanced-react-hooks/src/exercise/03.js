// useContext: simple Counter
// http://localhost:3000/isolated/exercise/03.js

import * as React from 'react'

// 🐨 create your CountContext here with React.createContext
const CountContext = React.createContext()

const useCounter = () => {
  const context = React.useContext(CountContext)

  if (!context) {
    throw new Error('useCounter must be used in a CountProvider.')
  }

  return context
}

const CountProvider = ({children}) => {
  const [counter, setCount] = React.useState(0)

  return (
    <CountContext.Provider
      value={{counter, increment: () => setCount(count => count + 1)}}
    >
      {children}
    </CountContext.Provider>
  )
}
// 🐨 create a CountProvider component here that does this:
//   🐨 get the count state and setCount updater with React.useState
//   🐨 create a `value` array with count and setCount
//   🐨 return your context provider with the value assigned to that array and forward all the other props
//   💰 more specifically, we need the children prop forwarded to the context provider

function CountDisplay() {
  // 🐨 get the count from useContext with the CountContext
  const {counter} = React.useContext(CountContext)
  const count = 0
  return <div>{`The current count is ${counter}`}</div>
}

function Counter() {
  const {increment} = React.useContext(CountContext)
  return <button onClick={increment}>Increment count</button>
}

function App() {
  return (
    <div>
      <CountProvider>
        <CountDisplay />
        <Counter />
      </CountProvider>
    </div>
  )
}

export default App
