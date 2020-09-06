function Greeter() {
  this.greeting = "Hello World";
  this.greeter = function () {
    console.log(
      "dirname: " +
        __dirname +
        ", filename: " +
        __filename +
        ", message: " +
        this.greeting
    );
  };
}

module.exports = new Greeter();
