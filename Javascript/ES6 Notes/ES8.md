# ES8

## padStart() and padEnd()

They take two arguments:

    1. The minimum length
    2. The string you want to pad with (default ' ')

```javascript
const num = "1";
const numFormatted = num.padStart(2, "0");
console.log(numFormatted);
```

> 01

## Object.values() and Object.entries()

- If we want to iterate over an object's values, use `Object.values()`.
- If we want to iterate over an object's key-value mappings, use `Object.entries()`.
- These two methods were added to the `Object` prototype.

```javascript
const person = {
  name: "Veeb",
  age: 20
};

// Old way
const personVals = [];
for (prop in person) {
  personVals.push(person[prop]);
}
console.log(personVals);

//New way
console.log(person.values());

//Entry iteration - gives an array of arrays
console.log(person.entries());
for (entry in person.entries()) {
  console.log(entry[0]);
  console.log(entry[1]);
}
```

> ["Veeb", 20]

> ["Veeb", 20]

> [ ["name", "Veeb"], ["age", 20] ]

> "name"

> "Veeb"

> "age"

> 20

## async and await

- The first thing to note is that under the hood, _nothing in Javascript has changed in implementation_.
- `async` and `await` is simply a sugar that allows us to write code that _looks_ synchronous, when it's not.
- While **Promises** are an improvement on callback hell, they still can be a bit tedious, so `async` improves on that.
- `await` can only be used in an `async` function.

### Promise only example

```javascript
const connection = mysql.createConnection(config);

function getAllUsers() {
    return new Promise(resolve, reject) => {
        connection.query("SELECT * FROM Users;", (error, results) => {
            if (error) {
                reject(error);
            } else {
                resolve(results);
            }
        });
    };
}

function printAllUsers() {
    getAllUsers()
        .then(data => console.log(data))
        .catch(error => console.log(error));
}

printAllUsers()
```

## Using async-await

```javascript
const connection = mysql.createConnection(config);
//remains the same
function getAllUsers() {
    return new Promise(resolve, reject) => {
        connection.query("SELECT * FROM Users;", (error, results) => {
            if (error) {
                reject(error);
            } else {
                resolve(results);
            }
        });
    };
}

async function printAllUsers() {
    const userList = await getAllUsers();
    console.log(getAllUsers);
}

printAllUsers()
```

**Note:** If `reject()` is caught, an exception is thrown, so you would have to catch it.
