let message = "I am the original";

const msg = function (change) {
  if (change) {
    message = "I'm not the real deal";
  }
  console.log(message);
};

module.exports = msg;
