import { MatchRow } from "./MatchReader";
import { MatchAnalyzer } from "./MatchAnalyzer";
import { writeToConsole } from "./ReportOutput";

interface Analyzer {
  (input: string): number;
}

interface WriteToOutput {
  (): void;
}
export class Summary {
  constructor(public matchData: MatchRow[]) {}

  numberOfWinsToHtml(teamName: string) {}
  numberOfWinsToConsole(teamName: string) {
    const analyzer = new MatchAnalyzer(this.matchData);
    const numWins = analyzer.numberOfWins(teamName);
    const title = "Number of Match Wins Analysis";
    const content = `${teamName} won ${numWins} matches`;
    writeToConsole({ title, content });
  }
}
