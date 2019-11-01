# Default Function Arguments

Instead of doing the following:

```javascript
function makeAjaxRequest(url, method) {
  if (!method) {
    method = "GET";
  }
  //logic for request
}
```

We do this:

```javascript
function makeAjaxRequest(url, method = "GET") {
  //logic for request
}

makeAjaxRequest("www.google.com");
makeAjaxRequest("www.google.com", "POST");
```

What if you don't want method to populated with a default arg?
**Use `null` instead.**

- In Javascript, `undefined` means something has been declared but not yet assigned.
- `null` is a representation of _no value_ - declared and assigned, just without a value.
- **Default arguments only apply to `undefined` arguments.**
