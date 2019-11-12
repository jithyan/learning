# Basics

## Primitives and Objects

- In Javascript, there only primitives and objects.
- The primitives are:
  1. string
  2. number
  3. boolean
  4. null
  5. undefined
  6. symbol
- Everything else is an object (including arrays and functions).

## Value and Reference

- Whenever we _copy_ a **primitive**, we **copy by value**.

```javascript
let name = "Veeba";
const n2 = name; //copied by VALUE

name = "Bob";
//n2 will still equal "Veeba"
```

- Objects are **copied by reference**

```javascript
let obj = {
  name: "Veeba"
};
const o2 = obj; // copied by reference

obj.newField = "hello";

// now o2 will have field "ewField = "hello"
```

Keep in mind values of objects are copied by value.
