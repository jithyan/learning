document.querySelectorAll(".drum").forEach((b) => {
  b.addEventListener("click", handleClick);
});

document.addEventListener("keydown", handleKeydown);

const DRUMS = {
  __proto__: null,
  w: new Audio("./sounds/tom-1.mp3"),
  a: new Audio("./sounds/tom-2.mp3"),
  s: new Audio("./sounds/tom-3.mp3"),
  d: new Audio("./sounds/tom-4.mp3"),
  j: new Audio("./sounds/snare.mp3"),
  k: new Audio("./sounds/crash.mp3"),
  l: new Audio("./sounds/kick-bass.mp3"),
};

function buttonAnimation(currentKey) {
  const element = document.querySelector(`.${currentKey}`);

  if (element) {
    element.classList.add("pressed");
    setTimeout(() => {
      element.classList.remove("pressed");
    }, 100);
  }
}

function handleClick(e) {
  const key = this.innerText.toLowerCase();
  DRUMS[key]?.play();
  buttonAnimation(key);
}

function handleKeydown(e) {
  DRUMS[e.key]?.play();
  buttonAnimation(e.key);
}
