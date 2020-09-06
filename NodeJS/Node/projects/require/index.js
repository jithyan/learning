// Note how CJS modules can be placed anywhere, including in conditionals
const greet = require("./greet");
const messenger = require("./other");

greet.greeter(); // otuputs -> "Hello World"
greet.greeting = "SOMETHIGN DIFFERENT";

const greet2 = require("./greet");
greet2.greeter(); // outputs --> "SOMETHING DIFFERENT"

messenger(); // outputs --> "I am the original"
messenger(true); //outputs --> "I'm not the real deal"

const test = require("./test");
test(); //outputs --> "I'm not the real deal"
