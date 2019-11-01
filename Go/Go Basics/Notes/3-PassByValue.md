# Passing by Value in Go

- Strictly speaking, there's only one way to pass parameters in Go - by value.
- Everytime a variable is passed, a copy of its contents is passed and allocated at a different memory address. This includes structs.
- However you can pass by pointer, if you want to modify a variable in another function.

## Example

Passing by pointer

```go
package main

import "fmt"

type Person struct {
    firstName string
    lastName  string
}

func changeName(p *Person) {
    p.firstName = "Bob"
}

func main() {
    person := Person {
        firstName: "Alice",
        lastName: "Dow",
    }

    changeName(&person)

    fmt.Println(person)
}
```

**HOWEVER**

**There are contexts when to use one over the other:**

- Maps, Slices and Channels in Go are reference types EXCEPT when unintialized, so the choice is already made for us.
- If the variable is a large struct, it is preferable to pass by pointer to prevent a large amount of copying.
- If a variable must not be modified, then you have no choice but to pass by value.

## PERFORMANCE NOTE

- The Go's compiler uses escape analysis to determine if a variable can be safely allocated on the function's stack frame - which can be cheaper than heap allocation.
- Using pass by value simplifies the analysis and gives the variable a better chance of being allocated on the stack.
