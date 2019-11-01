# Basics

## Function Declaration

`func Println(a ...interface{}) (n int, err error)`

- The above is the declaration for Println in fmt.
- `...` means any number of values. Known as a variatic parameter
- `interface{}` means take a value of any type

## Compiler Errors Specific to Go

- You declare a variable and don't use it.
- You open braces on a new line (because the compiler inserts a semicolon everytime it sees a newline).

## Terminology

- Go to Golang spec and see _operators_ and _punctuation_.
- **Identifiers** - a name for program entities such as variables and types.

> identifier = letter {letter | digit}

- So all identifiers must start with a letter and can have 1 or more optional letters and digits - Backus-Naur form.
- Obviously keywords can't be used as identifiers.

- You can use "\_" to ignore a variable.

> :=

- Both declares a variable AND assigns a value. Known as the short variable declaration operator.

- A **statement** expresses an action to carry out.
- An **expression** always produces another value. It is a combination of one or more values, constants, variables, operators and functions.
- A **parameter** is the defined input to a function.
- An **argument** is what we pass into a function when we call it.
