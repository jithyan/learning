import { MatchReader } from "./MatchReader";
import { Summary } from "./Summary";

const matches = MatchReader.readFromCsv("./football.csv");
const summarizer = new Summary(matches);
summarizer.numberOfWinsToConsole("Man United");
