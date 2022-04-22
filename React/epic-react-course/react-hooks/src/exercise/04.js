// useState: tic tac toe
// http://localhost:3000/isolated/exercise/04.js

import * as React from 'react'

function useSyncLocalStorage(key, defaultVal = '') {
  const [state, setState] = React.useState(
    () => JSON.parse(window.localStorage.getItem(key)) ?? defaultVal,
  )

  React.useEffect(() => {
    window.localStorage.setItem(key, JSON.stringify(state))
  }, [state])

  return [state, setState]
}

function Board() {
  // 🐨 squares is the state for this component. Add useState for squares
  const [squares, setSquares] = useSyncLocalStorage(
    'squares',
    Array(9).fill(null),
  )

  console.table(squares)

  // 🐨 We'll need the following bits of derived state:
  // - nextValue ('X' or 'O')
  // - winner ('X', 'O', or null)
  // - status (`Winner: ${winner}`, `Scratch: Cat's game`, or `Next player: ${nextValue}`)
  // 💰 I've written the calculations for you! So you can use my utilities
  // below to create these variables

  // This is the function your square click handler will call. `square` should
  // be an index. So if they click the center square, this will be `4`.
  function selectSquare(square) {
    if (!Boolean(squares[square]) && !Boolean(calculateWinner(squares))) {
      setSquares(prev => {
        const nextSquares = [...prev]
        nextSquares[square] = calculateNextValue(squares)
        return nextSquares
      })
    }
  }

  function restart() {
    setSquares(Array(9).fill(null))
  }

  return (
    <div>
      {/* 🐨 put the status in the div below */}
      <div className="status">
        {calculateStatus(
          calculateWinner(squares),
          squares,
          calculateNextValue(squares),
        )}
      </div>
      <div className="board-row">
        {[0, 1, 2].map(pos => (
          <Square
            key={`${pos}-${squares[pos]}`}
            pos={pos}
            selectSquare={selectSquare}
            value={squares[pos]}
          />
        ))}
      </div>
      <div className="board-row">
        {[3, 4, 5].map(pos => (
          <Square
            key={`${pos}-${squares[pos]}`}
            pos={pos}
            selectSquare={selectSquare}
            value={squares[pos]}
          />
        ))}
      </div>
      <div className="board-row">
        {[6, 7, 8].map(pos => (
          <Square
            key={`${pos}-${squares[pos]}`}
            pos={pos}
            selectSquare={selectSquare}
            value={squares[pos]}
          />
        ))}
      </div>
      <button className="restart" onClick={restart}>
        restart
      </button>
    </div>
  )
}

function Square({selectSquare, pos, value}) {
  return (
    <button className="square" onClick={() => selectSquare(pos)}>
      {value}
    </button>
  )
}

function Game() {
  return (
    <div className="game">
      <div className="game-board">
        <Board />
      </div>
    </div>
  )
}

function calculateStatus(winner, squares, nextValue) {
  return winner
    ? `Winner: ${winner}`
    : squares.every(Boolean)
    ? `Scratch: Cat's game`
    : `Next player: ${nextValue}`
}

function calculateNextValue(squares) {
  return squares.filter(Boolean).length % 2 === 0 ? 'X' : 'O'
}

function calculateWinner(squares) {
  const lines = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6],
  ]
  for (let i = 0; i < lines.length; i++) {
    const [a, b, c] = lines[i]
    if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
      return squares[a]
    }
  }
  return null
}

function App() {
  return <Game />
}

export default App
