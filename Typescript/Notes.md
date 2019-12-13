# Typescript Notes

## Conventions

### Exports

- In the **Typescript _community_**, `export default` statements are **not** used.
- An `export default` essentially exports a _value_ not a named object.

### Type Definitions

- These are laid out in a file with extension: d.ts

## Other

- You can install type definition files for not only NPM modules, but objects downloaded from a script (e.g. Google Maps);
- `interface`s will accept any object that satisfies the interface (i.e. it must have at least the interface's mandatory properties, and more).
- When you define a type such as `function(arg: User | Company)`, the only properties in `arg` you can access are those _common to both_ `User` and `Company`.

## Tools, Compiler

- Install **parcel-bundler** and use it to compile and serve a web-app automatically, using `parcel path\to\index.html`. Note that `index.html` should include the `index.ts` script tag.

### Basic Setup of a new Typescript project

1. Create a new directory.
2. Run `tsc --init` to generate your `tsconfig.json` file.
3. Create an `src` sub-directory that will house all your **Typescript** files.
4. Create a `build` sub-directory that will house all the _compiled_ **Javascript** files.
5. Go to the `tsconfig.json` file and uncomment out the following:
   - `outDir`: Relative path to your build files directory.
   - `rootDir`: This is a relative path to your source code.
6. Now you can just run `tsc` _by itself_.

### Concurrent compilation and execution

1. Run `tsc -w`. This is watch mode, and it should be run in its own console. Now your code will be _compiled automatically_.
2. Run `yarn init`
3. Install `nodemon` and `concurrently`.
   - **concurrently** allows you to execute multiple scripts concurrently.
   - **nodemon** executes Javascripts files.
4. Add the following into the scripts section in `package.json`:

```javascript
  "scripts": {
    "start:build": "tsc -w",
    "start:run": "nodemon build/index.js",
    "start": "concurrently yarn:start:*"
  },
```

5. Now you can run `yarn start` to automatically watch for changes, compile them and execute them immediately in one window.
