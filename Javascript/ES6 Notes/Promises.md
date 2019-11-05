# Promises

## How Javascript Executes Code

There is no way in Javascript to "pause" the execution of code (like `sleep(1000)`).

![promise1](./img/promise1.PNG)

In the above example, `console.log(data)` would be `undefined`. Because it will be executed immediately after the `makeRequest` function.

![promise2](./img/promise2.PNG)

This is what we want - to only execute code once the long running process has completed.

## Terminology

![promise3](./img/promise3.PNG)

![promise4](./img/promise4.PNG)

`then` and `catch` are _properties_ of **Promise** objects that are for registering callbacks on success or failure.
