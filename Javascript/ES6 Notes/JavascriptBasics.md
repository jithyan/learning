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

## Javascript's Asynchronous Nature

Javascript unlike most languages is asynchronous. If at any point it has to wait, it will add whatever it has to wait for to an event queue and skip to the next line. Once it checks its event queue for any events that have completed, it will then execute the callback.

An analogy is that of a call centre. You can call the centre and they will put you on hold until there's someone available. But another way of doing it is where the centre puts you in a queue and call you once they have someone available. Javascript is like the latter.
