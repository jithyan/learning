# Classes

- Javascript uses prototypal inheritance.
- In order to make OOP more straightforward, ES6 introduced classes.
- However, **classes compile to prototypal inheritance objects**.

## ES5 Object Definition with Inheritance

```javascript
function Car(options) {
  this.title = options.title;
}

Car.prototype.drive = function() {
  return "vroom";
};

const car = new Car({ title: "Focus" });
car.drive(); //vroom

function Toyota(options) {
  this.color = options.color;
}

Toyota.prototype = Object.create(Car.prototype);
Toyota.prototype.constructor = Toyota;

Toyota.prototype.honk = function() {
  return "beep";
};

const toyota = new Toyota({ color: "red", title: "Daily Driver" });
```

**Lots of boiler plate!**

## ES6 Classes

```javascript
class Car {
  constructor({ title }) {
    this.title = options.title;
  }

  drive() {
    return "vroom";
  }
}

const car = new Car({ title: "Toyota" });

class Toyota extends Car {
  constructor(options) {
    super(options);
    this.color = options.color;
  }

  honk() {
    return "beep";
  }
}

const toyota = new Toyota({ title: "Daily Driver", color: "Red" });
```

## When Will We Use Classes?

Class creation used to be so cumbersome in ES5, in React, you'd create classes using a helper like so:

```javascript
React.createClass({
  doSomething() {},
  soSomethingElse() {}
});
```

ES6 has been the most widely and quicky embraced feature in the community.

## Static methods

Works the same way as in other languages. Works against the class instead of the object.

```javascript
class SuperHero {
  constructor(name, power) {
    this.name = name;
    this.power = power;
  }

  static isGood() {
    return true;
  }
}
```

## Accessors

You can use "getters" and "setters" to access object get and set methods like _properties_.

Example of read only implementation:

```javascript
class A {
  constructor(_data) {
    this._data = _data;
  }

  get data() {
    return this.data;
  }
}

const a = new A("hello");
console.log(a.data);
// will not work - a.data = "bye"
```

Note in the example above, we have to use `_data` instead of `data` in the constructor, because without a **setter** you can't do any assignment.

## Rule of Thumb for "this"

> "this" will be equal to whatever is to the left of the function/property call.

Example:

```javascript
const colors = {
  color: 'red',
  printColor(): {
    console.log(this.color);
  },
};

colors.printColor(); // this works

const printColor = colors.printColor;
printColor(); //WILL FAIL: this.color -> undefined.color
```

### Easiest solution

- Use "Fat Arrow" functions (i.e. function expressions) only.
- The performance impact is so minimal that it doesn't matter.
- Alternatively you have to bind the function/property to the appropriate object.
