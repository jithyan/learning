# Asynchronous code, libuv, The Event Loop, and more...

- NodeJS is asynchronous. Javascript (and V8) are **synchronous**.

![libuv](./img/4_async_1.png)

- libuv is used to interact with the operating system, and is the basis of events emitted from the OS.

![buffer](./img/4_async_2.png)

![streams](./img/4_async_3.png)

- `Buffer` is a globally available class in NodeJS.

```javascript
let buf = new Buffer("Hello", "utf8");
```

- Buffer will convert the string 'Hello' to binary data, and encode it as 'utf8' (which is the default).

![buffer-1](./img/4_async_4.png)

![buffer-2](./img/4_async_5.png)

## Typed Arrays

- Javascript used to be unable to deal with raw binary data.
- Because of that, Node provides the Buffer class.
- However with **ES6**, we can deal with binary data using typed arrays.
- More info: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Typed_arrays
