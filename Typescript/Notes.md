# Typescript Notes

## Conventions

### Exports

- In the **Typescript _community_**, `export default` statements are **not** used.
- An `export default` essentially exports a _value_ not a named object.

### Type Definitions

- These are laid out in a file with extension: d.ts
- To install type definition files for the NodeJS library, use `yarn add @types/node`. Note that if you fail to do so, if you use an import statement, Typescript will give an incorrect "module does not exist" error.

![tyepdef](./img/typedef.PNG)

The above shows how Typescript can interface with any Javascript library, provided a type definition file is provided.

### Enums

![enums](./img/enums.PNG)

![jsenums](./img/jsenum.PNG)

## Other

- You can install type definition files for not only NPM modules, but objects downloaded from a script (e.g. Google Maps);
- `interface`s will accept any object that satisfies the interface (i.e. it must have at least the interface's mandatory properties, and more).
- When you define a type such as `function(arg: User | Company)`, the only properties in `arg` you can access are those _common to both_ `User` and `Company`.

## Tools, Compiler

- Install **parcel-bundler** and use it to compile and serve a web-app automatically, using `parcel path\to\index.html`. Note that `index.html` should include the `index.ts` script tag.

### Basic Setup of a new Typescript project

1. Create a new directory.
2. Run `tsc --init` to generate your `tsconfig.json` file. **By virtue of just having the tsconfig.json file, strict type checking will be enabled.**
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

## Generics

### Function Generics

Example:

```typescript
function printAnything<T>(arr: T[]): void {
  console.log(arr);
}
```

### Generic Constraints

This essentially constrains a Generic class to have implemented or extended another interface or class.

```typescript
interface Printable {
  print(): void;
}

function printSomething<T extends Printable>(T something) {
  something.print();
}
```

This allows you to make sure that the generic type has the property or method required.

## Types for Objects with unknown property names

```typescript
interface LanguagePack {
  [key: string]: string;
}
```

- In Javascript, object **keys** (aka properties, attributes, fields) are always of type **string**, and if numbers are used, they are _implicitly converted_.
- The syntax `[key: string]` tells Typescript you're expecting a string as a key with the name not known in advance.

## Advanced Generic Constraint - Value is a key of an object

In the scenario where a generic value should be the **key** of an **object properties** _and_ the return value is type of object assigned to the key:

```typescript
interface UserProps {
  name: string;
  age: number;
}

const data: UserProps = { name: "Tom", age: 27 };

function getVal<K extends keyof T>(key: string): T[K] {
  return data[key];
}

const name = getVal<UserProps>("name");
const age = getVal<UserProps>("age");
//compile error - const unknown = getVal<UserProps>("random");
```

Typescript will know:

- name is a string.
- age will be a number.
