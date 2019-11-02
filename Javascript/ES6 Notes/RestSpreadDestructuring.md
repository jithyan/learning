# Rest and Spread Operators and Destructuring

## The Rest Operator

- This basically allows you to have variadic parameters for a function.
- You put the rest operator in the function, and you're able access the arguments as an array.

```javascript
addNumbers(1, 2, 4);

function addNumbers(...numbers) {
  return numbers.reduce((acc, number) => acc + number, 0);
}
```

## The Spread Operator

Say you have two arrays, and you want a flat array of both arrays:

```javascript
const defaultColors = ["red", "green"];
const userFavColors = ["pink", "blue"];
```

One way of doing it is:

`defaultColors.concat(userFavColors);`

In ES6, you can use the spread operator:

`[...defaultColors, ...userFavColors]`

**This has the added advantage of being able to add new elements to the new array as well in the same line, unlike when you use concat.**

## Destructuring

### Object Destructuring

//ES5

```javascript
var expense = { type: "travel", amount: 340 };

var type = expense.type;
var amount = expense.amount;
```

//ES6

```javascript
const { type, amount } = expense;
```

- The new variable name must be exact name of the object property name.
- Can be used to destructure objects passed into a function.

### Array Destructuring

```javascript
const companies = ["Facebook", "Google", "Uber"];

const [evilCompany, megaCompany, unicornCompany] = companies;

// evilCompany = 'Facebook', etc...
```

You can also do the following:

```javascript
const companies = ["Payoneer", "Uber", "WeWork"];

const [legit, ...unicorns] = companies;

//legit = Payoneer
// unicorns = ['Uber', 'WeWork']
```

### Advanced Examples

I want to just get the location of Google from this list.

```javascript
const companies = [
  { name: "Google", location: "Mountain View" },
  { name: "Facebook", location: "Menlo Park" }
];

const [{ location }] = companies;

// location = 'Mountain View'
```

E.g. 2

```javascript
const Google = {
  locations: ["Mountain View", "New York", "London"]
};

const {
  locations: [location]
} = Google;

// location = 'Mountain View';
```
