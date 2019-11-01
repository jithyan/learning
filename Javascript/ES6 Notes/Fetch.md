# Fetch

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

## Gotcha with Fetch

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
