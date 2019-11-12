# Symbols

- The data type symbol is a primitive data type.
- The `Symbol()` function returns a value of type symbol, that has some static properties and methods, and resembles a built-in object class but is incomplete as a constructor because it does not support the syntax `new Symbol()`.
- **Every symbol** value returned from `Symbol()` is _unique_.
- A symbol value may be used as an identifier for object properties; **this is the data type's only purpose**.

`let s = Symbol("mySymbol")`

## The Best Use Case for Symbols

Symbols are similar to GUIDs, and their best use case is for restricting access to fields in objects.

Scenario:

```javascript
class MyCar {
  constructor(color, make) {
    this.color = color;
    this.make = make;
  }
}
console.log(new MyCar("blue", "Toyota"));
```

_Output:_

> {color: 'blue', make: 'Toyota'}

Everyone has visibility and access to the fields of the above object.

We can use Symbols to restrict access and visibility:

```javascript
const COLOR = Symbol();
const MAKE = Symbol();

class MyCar {
  constructor(color, make) {
    this[COLOR] = color;
    this[MAKE] = make;
  }
}
const mycar = new MyCar("blue", "Toyota");
console.log(mycar);
console.log(mycar[COLOR]);
```

_Output:_

> {}

> 'blue'

**This means only if you have access to the symbol references can you access an object's fields.**

If you do want to have accessors to your symbol properties:

```javascript
const COLOR = Symbol();
const MAKE = Symbol();

class MyCar {
  constructor(color, make) {
    this[COLOR] = color;
    this[MAKE] = make;
  }

  get color() {
    return this[COLOR];
  }

  set color(newColor) {
    this[COLOR] = newColor;
  }
}
```

## Well Known Symbols

### Iteration symbols

- Symbol.iterator
  A method returning the default iterator for an object. Used by `for...of`.

- Symbol.asyncIterator
  A method that returns the default AsyncIterator for an object. Used by for `await...of`.

### Regular expression symbols

- Symbol.match
  A method that matches against a string, also used to determine if an object may be used as a regular expression. Used by `String.prototype.match()`.

- Symbol.matchAll
  A method that returns an iterator, that yields matches of the regular expression against a string. Used by `String.prototype.matchAll()`.

- Symbol.replace
  A method that replaces matched substrings of a string. Used by `String.prototype.replace()`.

- Symbol.search
  A method that returns the index within a string that matches the regular expression. Used by `String.prototype.search()`.
- Symbol.split
  A method that splits a string at the indices that match a regular expression. Used by `String.prototype.split()`.

### Other symbols

- Symbol.hasInstance
  A method determining if a constructor object recognizes an object as its instance. Used by `instanceof`.

- Symbol.isConcatSpreadable
  A Boolean value indicating if an object should be flattened to its array elements. Used by `Array.prototype.concat()`.

- Symbol.toStringTag
  A string value used for the default description of an object. Used by `Object.prototype.toString()`
