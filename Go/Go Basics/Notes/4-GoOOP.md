# OOP in Go

- We create _VALUES_ of a certain **TYPE** that are stored in **VARIABLES** which have **IDENTIFIERS**.
- Go has _types_ and _methods_ and allows OOP style. **But no hierarchy**. Only has concept of "_interface_".
- **Go is all about TYPE.**

## Go's OOP Aspects

1. Encapsulation (via structs)
   a. state (fields)
   b. behaviour (methods)
   c. exported & unexported viewable and not viewable (packages)

2. Reusability
   a. inheritance (embedded types)

3. Polymorphism
   a. interfaces

4. Overriding
   a. "promotion

In Go:

1. You don't create classes, you create a type
2. you don't instantiate, you create a value of a type

- It's bad practice to alias types, unless you need to attach methods to a type.
