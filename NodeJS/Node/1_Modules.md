# How do Node modules work

## Module Systems

- Javascript wasn't originally designed to be modular, and a number of systems were implemented for it to support it.
- CJS is an implementation for NodeJS, which isn't suported by browsers/V8. Such code needs to be transpiled.
- `ESM` stands for `ECMAScript Modules` and is a new standard that is a part of `ES6` for managing Javascript modules. It is supported by both browsers and NodeJS (in new versions, that is).

## How CJS Works

```javascript
var greet = require('./greet)
```

1. `require` is a vanilla Javascript function, that on a high level, loads and caches a given script.
2. `require` can be executed anywhere in a file (including conditionally)
3. `require` wraps the script in a file with the following:

```javascript
function (exports, require, module, __filename, __dirname) {
    //your code loaded previously is injected here
    // your code will have the following line:
    module.exports = //ref to object/primitive
}
```

Implications about the above snippet:

1. All your NodeJS modules will have access to those arguments.
2. `require` will only return what is in `module.exports`.
3. You can conditionally export objects!

> **Important:** Node caches the result of the `require`. If you return an object, that is a singleton across the entire project. See the `require` folder in the `projects` directory for a demo.

## ESM and how it differs from CJS

1. ESM modules can be imported both _synchronously_ and _asychronously_.
2. Imports can only happen in the top of a file, and not conditionally.
3. Exports cannot be conditional.
4. In other words, imports/exports must be static. As a result of this, tree-shaking optimization can be done (i.e. dead code elimination).
5. ESM is the preferred approach.

## Another require example

```javascript
// file greet.js
function Greetr() {
  this.greeting = "Hello world";
  this.greet = function () {
    console.log(this.greeting);
  };
}
module.exports = new Greetr();

//file server.js
const greet = require('greet').greet
greet();

const greet2 = require('greet');
greet2.greet();
greet2.greeting = "Goodbye cruel world";

const greet3 = require('greet);
greet3.greet();
```

Result:

> > > "Hello world"
> > > "Hello world"
> > > "Goodby cruel world"

- `new Greetr()` is **only executed once** throughout the project.
- `greet1`, `greet2` and `greet3` all point to the same object!;
