# Array Helpers

**Note**: _This is technically ES5.1_

## forEach

Loop through every element in the array.

## map

Generate a new list by iterating through an existing array.

## filter

- Filter all the elements in an array based on some criteria.
- Returns an empty array if nothing is found.

## find

- Find the **first** element in an array that matches some criteria.
- Returns `undefined` if nothing is found.

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
