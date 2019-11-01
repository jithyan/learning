# Enhanced Object Literals

## ES5 Way of Defining Objects

```javascript
function createBookshop(inventory) {
  return {
    inventory: inventory,
    inventoryValue: function() {
      return this.inventory.reduce((total, book) => total + book.price, 0);
    }
    priceForTitle: function(title) {
        return this.inventory.find(book => book.title === title).price;
    }
  };
}

const inventory = [
  { title: "Harry PotteR", price: 10 },
  { title: "Eloquent Javascript", price: 15 }
];
```

## ES6 Enhanced Object Literals

1. Whenever the key and value name are the same, we can omit the value name in the object. By convention, these should be listed first.
2. Whenever we have a key/value pair, where the _value is a function_, you can omit the `function` keyword.

The above object literal can be reworked as:

```javascript
function createBookshop(inventory) {
  return {
    inventory, //1
    inventoryValue() { //2
      return this.inventory.reduce((total, book) => total + book.price, 0);
    }
    priceForTitle(title) { //2
        return this.inventory.find(book => book.title === title).price;
    }
  };
}
```
