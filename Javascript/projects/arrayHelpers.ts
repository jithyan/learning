// forEach
const numbers = [1, 2, 3, 4, 5];

var sum = 0;
numbers.forEach(function(number) {
  sum += number;
});

console.log(`forEach demo - sum is: ${sum}`);

// map
const squared = numbers.map(function(number) {
  return number * number;
});

console.log(`map demo - squared is: ${squared}`);

// filter
type Product = { name: string; type: string };
const products: Product[] = [
  { name: "banana", type: "fruit" },
  { name: "celery", type: "vegetable" },
  { name: "strawberry", type: "fruit" },
  { name: "broccoli", type: "vegetable" }
];

const fruits = products.filter(function(product) {
  return product.type === "fruit";
});

console.log(`filter demo - fruits: ${JSON.stringify(fruits)}`);

// find
type User = { name: string };
const users: User[] = [
  { name: "Jill" },
  { name: "Jack" },
  { name: "Alex" },
  { name: "Bill" }
];

const alex = users.find(function(user) {
  return user.name === "Alex";
});

console.log(`find demo - found user: ${JSON.stringify(alex)}`);

// every and some

const computers = [
  { name: "Apple", ram: 24 },
  { name: "Compaq", ram: 4 },
  { name: "Acer", ram: 32 }
];

// Yes or No - do I have any computers that can run a program that requires 16GB?

var allComputersCanRunProgram = true;
var onlySomeProgramsCanRunProgram = false;

// Old way of doing this
for (var i = 0; i < computers.length; i++) {
  const computer = computers[i];

  if (computer.ram < 16) {
    allComputersCanRunProgram = false;
  } else {
    onlySomeProgramsCanRunProgram = true;
  }
}

//New way
const canAllComputersRunProgram = computers.every(function(computer) {
  return computer.ram > 16; //if true for all items, then result is true
});

const canAtLeastOneComputerRunProgram = computers.some(function(computer) {
  return computer.ram > 16;
});
