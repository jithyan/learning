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

## Creating Promises

![promise5](./img/promise5.PNG)

The above throws an error because it request one argument to be passed - a callback:

```javascript
const promise = new Promise((resolve, reject) => {
  //some long running code
  if (result === "success") {
    resolve();
  } else {
    reject();
  }
});
```

If you didn't call resolve or reject, the status of the promise would be **"pending"**. E.g:

![promise6](./img/promise6.PNG)

It's up to us to decide when to resolve or reject a promise, which will change the state of the promise.

What happens when a promise is rejected?

![promise7](./img/promise7.PNG)

## "then" and "catch"

- By calling `resolve()` we indicate a promise was a success.
- By calling `reject()` we indicate that the promise failed.
- We need then need a way to determine what should happen if a promise fails or succeeds.
- We do this by registering callbacks to a promise's `then` and `catch` properties.

```javascript
const promise = new Promise();

promise
  .then(() => {
    console.log("an outstanding success");
  })
  .then(() => {
    console.log("another success!");
  });
// then and catch callbacks can be chained!
promise.catch(() => console.log("A fail"));
```

## Fetch

Example of using `fetch` to get JSON data:

```javascript
const url = "https://jsonplaceholder.typicode.com/posts/";

fetch(url)
  .then(response => response.json())
  .then(data => console.log(data));
```

- Note that the response doesn't immediately return the parsed data - we need to do it as a result of the first callback.
- Only in the second callback do we get the data after having called `json()`.

The reason is, when we make a successful call to fetch, we get the following response object:

![fetch1](./img/fetch1.PNG)

### Gotcha with Fetch

```javascript
const bad_url = "https://jsonplaceholder.typicode.com/DOES_NOT_EXIST/";

fetch(url)
  .then(response => console.log(response))
  .catch(error => console.log("ERROR!"));
```

- The above URL will return a 404. We expect the catch callback to be executed.
- It _does not_ get executed. Instead, the `then` callback is executed.
- This `catch` callback is only executed on **failed network requests** - i.e. no server response, like a bad domain name, no internet, etc.

> In order to determine if the server threw an error, we need to check `response.status` in the `then` callback!
