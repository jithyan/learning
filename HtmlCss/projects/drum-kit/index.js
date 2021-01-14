document
  .querySelectorAll(".drum")
  .forEach((b) => b.addEventListener("click", handleClick));

function handleClick(e) {
  const audio = new Audio("./sounds/tom-1.mp3");
  audio.play();
}
