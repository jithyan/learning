import * as fs from "fs";

fs.readdir("./data", (err, files) => {
  const filePromises = files.map(function(fileName) {
    return new Promise<string>((resolve, reject) => {
      fs.readFile(`./data/${fileName}`, (err, data) => {
        if (err) {
          reject(err);
        } else {
          resolve(String(data));
        }
      });
    });
  });

  Promise.all(filePromises)
    .then(data => {
      const sumLength = data.reduce((acc, curr) => acc + curr.length, 0);
      console.log(`The total length of all files is ${sumLength}`);
    })
    .catch(err => console.log(err));
});
