# Express

Express is two things:

1. Router
2. Middleware

Request --> Middleware --> Response

> Middleware in Express is any function that has access to the `req`, `res` and `next` object.

## Sharing intermediate results across middleware

There are a number of ways of doing this:

1. `res.locals`
2. `req.locals`
3. `res.myKey` or `req.myKey`

- `res.locals` is meant to be used for storing data for a view engine. You shouldn't use it to store other variables in case it clobbers data meant for views.
- It is **common practice** to use `req.locals` for storing intermediate data, though it isn't officially documented.

> `res.locals` and `req.locals` are only persistent for the lifetime of a **request**.

## app.locals

This is used to store data that persists across the life of the **application**.

```javascript
console.dir(app.locals.title);
// => 'My App'

console.dir(app.locals.email);
// => 'me@myapp.com'
```

## Setup for a basic Express app

```javascript
const express = require("express");
const helmet = require("helmet");

const app = express();

app.use(helmet);
app.use(express.json());
app.use(express.static("public"));
app.use(express.urlencoded({ extended: false }));
```

1. `express.json()` allows you to parse application/type JSON requests, and allows you to access it via `req.body`.
2. `express.static(dirName)` allows you to serve static files in the given directory.
3. `express.urlencoded()` allows you to parse MIME type of urlencoded requests and access the body in `req`.
4. `helmet` helps to secure your server by setting various HTTP headers.

## View Engines

- These essentially allow you to easily serve server-side rendered HTML files.
- You use a _view engine_, such as **EJS**, **Handlebars** or **Mustache**, which allows you to use templates and variables to dynamically render HTML.

In order to serve dynamic HTML, you:

1. Set the view engine to your provider, using `app.set`, e.g: `app.set('view', 'ejs')`
2. Define your template specific for your view engine, which is stored in an appropriate folder in your app.
3. Call `res.render`, giving it two things:
   - The template file you want to use.
   - The data you want to send that file (**Note:** Express puts that data into `res.locals`).

## app.get and app.set

- This essentially a hashmap of keys to values.
- You can set any key name you like, however there are special keys used to configure your express app, like "view".
- In short, use this save application wide key-value pairs, but mainly to configure your express app.

## Cookies and Sessions

- Cookies store data about a session on the client.
- Sessions store data about a session on the server.
- These can be easily dealt with using middleware!

With the appropriate middleware cookie-parser, you can set a cookie by:

```javascript
res.cookie("username", username);
```

You can now access it using:

```javascript
req.cookies.username;
```

You can use `res.clearCookie()` to clear out the cookie.
