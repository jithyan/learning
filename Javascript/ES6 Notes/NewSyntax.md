# New Syntax

## Const, Let and Var

- In _ES6_, you will **never use** `var`.
- You either use `const` or `let`.
- Use `const` for values that will never change.
- Use `let` for values that could change.

## Template Strings

Allows you to inject a Javascript expression into a string, by simply using backticks:

```javascript
function getMessage() {
  return `The year is ${new Date().getFullYear()}`;
}
```
