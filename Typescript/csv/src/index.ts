import fs from "fs";

enum MatchResult {
  HOME_WIN = "H",
  AWAY_WIN = "A",
  DRAW = "D"
}

const matches = fs
  .readFileSync("./football.csv", { encoding: "utf-8" })
  .split("\n")
  .map(row => row.split(","));

let manUWins = 0;
const manUName = "Man United";
matches.forEach(match => {
  if (
    (match[1] === manUName && match[5] === MatchResult.HOME_WIN) ||
    (match[2] === manUName && match[5] === MatchResult.AWAY_WIN)
  ) {
    manUWins++;
  }
});
console.log(`Manchester United had ${manUWins} wins`);
