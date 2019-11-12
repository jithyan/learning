# Map and Set

## Map

Maps are very similar to regular Javascript objects, however there a number of differences that make it preferable over them: - They have some useful properties and helper methods. - You can easily instantiate an empty Map and add key-value pairs later. - You can iterate over Maps, and the order is preserved. - You can use **functions** as _keys_.

### Basic Usage

```javascript
let myContacts = new Map();

//add an entry
myContacts.set("Robert", "+94771133747");

//get a value
myContacts.get("Robert"); //returns "+94771133747"

//has a key?
myContacts.get("Robert"); //true

//Use functions as keys
const someFunct = () => console.log("Hello");
myContacts.set(someFunct, "A function is my key!");
myContacts.get(someFunct);

//iteration
myContacts.forEach(value => console.log(value));

for (entry of myContacts) {
  console.log(entry); //prints the key-value pair
}

//number of elements
console.log(myContacts.size);
```

### Useful Helper Methods

- `entries()`
  Get all the entries in the Map.

- `keys()`
  Get all the keys in the Map.

- `values()`
  Get all the values in the Map.

- `clear()`
  Empties the map of any entries.

### Weak Maps

1. A weakMap will allow garbage collection of the key has no reference. That is, if an object which is a key has become `null`, the key would still remain in a `Map` - however a `weakMap` will remove the entire entry.
2. It's not an iterable.
3. It only has `get`, `set`, `has` and `delete`.

## Set

Similar to in Java. However, there are some differences.

For example, it uses only referential equality when adding objects.

```javascript
const s = new Set();
s.add({
  name: "Robert",
  lastname: "Sandy"
});
s.add({
  name: "Robert",
  lastname: "Sandy"
});
console.log(s.size); //2
```

Internally, Sets store its elements as _key-value pairs_, similar to map.
Therefore it also has an `entries()` method.

### Common Methods

- `has(val)`
- `add(val)`
- `clear()`
- `keys()`
- `values()`
- `entries()`
- `delete(val)`

### Weak Sets

1. Like WeakMap, the primary gain is _garbage collection_.
2. Unlike Set, it can **ONLY** hold _objects_.
3. It is not iterable.
4. No `get` method, and `size` is always **0**.

Typically used to tag objects.
