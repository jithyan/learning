# Array Helpers

**Note**: _This is technically ES5.1_

## forEach

Loop through every element in the array.

## map

Generate a new list by iterating through an existing array.

> array.map( callback(currentValue, index \[optional\], array \[optional\]) => return newValue )

## filter

- Filter all the elements in an array based on some criteria.
- Returns an empty array if nothing is found.

## find

- Find the **first** element in an array that matches some criteria.
- Returns `undefined` if nothing is found.

## findIndex

- Works exactly the same as `find()` but returns the **index** of the first found value.

## every

![every](./img/every.PNG)

Returns true if _all_ (i.e. every) elements of the array satisfy a boolean condition.

## some

![some](./img/some.PNG)

Returns true if _at least one_ (i.e. some) elements of the array satisfy a boolean condition.

## reduce

![reduce](./img/reduce.PNG)

- Condenses an entire array to a single value.
- The above example shows an example of summing numbers within an array.
- You always start with an initial value as the second argument to reduce. **This is the most important thing to think about!**
- The function to reduce takes: an accumulator, the current element of the array

## reduceRight

Same as `reduce`, but works from **right to left** - i.e. from the end to the start of the array.

## fill

The `fill()` method fills (modifies) all the elements of an array from a start index (default zero) to an end index (default array length) with a static value. It returns the modified array.

```javascript
const array1 = [1, 2, 3, 4];

// fill with 0 from position 2 until position 4
console.log(array1.fill(0, 2, 4));
// expected output: [1, 2, 0, 0]

// fill with 5 from position 1
console.log(array1.fill(5, 1));
// expected output: [1, 5, 5, 5]

console.log(array1.fill(6));
// expected output: [6, 6, 6, 6]
```

This is similar to splice, but it simply fills all the specified indices with a single value (with splice, you need to specify every element that gets added).

## Useful JS array helpers (before ES6)

### splice

The `splice()` method changes the contents of an array by removing or replacing existing elements and/or adding new elements in place.

**splice() mutates the array.**

> const arrDeletedItems = array.splice(start[, deleteCount[, item1[, item2[, ...]]]])

- **start** - start index
- **deleteCount** - _optional_ number of elements to delete.
- **item...** - _optional_ items to add to the array. If none specified, then items will only be removed.

```javascript
const months = ["Jan", "March", "April", "June"];
months.splice(1, 0, "Feb");
// inserts at index 1
console.log(months);
// expected output: Array ['Jan', 'Feb', 'March', 'April', 'June']

months.splice(4, 1, "May");
// replaces 1 element at index 4
console.log(months);
// expected output: Array ['Jan', 'Feb', 'March', 'April', 'May']
```

### slice()

The slice() method returns a shallow copy of a portion of an array into a new array object selected from begin to end (end not included) where begin and end represent the index of items in that array. The original array will not be modified.

```javascript
var animals = ["ant", "bison", "camel", "duck", "elephant"];

console.log(animals.slice(2));
// expected output: Array ["camel", "duck", "elephant"]

console.log(animals.slice(2, 4));
// expected output: Array ["camel", "duck"]

console.log(animals.slice(1, 5));
// expected output: Array ["bison", "camel", "duck", "elephant"]
```
