import { CsvFileReader } from "./CsvFileReader";

export enum MatchResult {
  AWAY_WIN = "A",
  HOME_WIN = "H",
  DRAW = "D"
}
export type MatchRow = [
  Date,
  string,
  string,
  number,
  number,
  MatchResult,
  string
];

function parseDate(date: string): Date {
  const dateParts = date.split("/").map(part => parseInt(part));
  return new Date(dateParts[2], dateParts[1] - 1, dateParts[0]);
}

export class MatchReader {
  static readFromCsv(filename: string): MatchRow[] {
    const csvData = new CsvFileReader(filename).read();
    return csvData.map(row => {
      return [
        parseDate(row[0]),
        row[1],
        row[2],
        parseInt(row[3]),
        parseInt(row[4]),
        row[5] as MatchResult,
        row[6]
      ];
    });
  }
}
