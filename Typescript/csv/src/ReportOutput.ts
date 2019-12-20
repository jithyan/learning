import fs from "fs";

export interface ReportOptions {
  title: string;
  content: string;
}

export function writeToConsole({ title, content }: ReportOptions) {
  console.log("===================================");
  console.log(`    ${title}   `);
  console.log("===================================");
  console.log(`${content}`);
}

export function writeToHtml(report: ReportOptions) {
  const output = `
    <html>
        <body>
            <h1>${report.title}</h1>
            <br />
            <div>
                ${report.content}
            </div>
        </body>
    </html>
    `;
  fs.writeFileSync("report.html", output, { encoding: "utf-8" });
}
