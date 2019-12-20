import { MatchRow, MatchResult } from "./MatchReader";

export class MatchAnalyzer {
  constructor(public matchData: MatchRow[]) {}

  numberOfWins(teamName: string): number {
    let numWins = 0;
    this.matchData.forEach(match => {
      if (
        (match[1] === teamName && match[5] === MatchResult.HOME_WIN) ||
        (match[2] === teamName && match[5] === MatchResult.AWAY_WIN)
      ) {
        numWins++;
      }
    });

    return numWins;
  }
}
