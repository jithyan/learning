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
