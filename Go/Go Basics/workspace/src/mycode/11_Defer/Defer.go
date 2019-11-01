package main

import "fmt"

/*
A defer statement defers the execution of a function until the surrounding
function returns.

Defer is commonly used to simplify functions that perform various clean-up actions.
For example, if you open a file, you can defer closing it in the next line.
This will guarantee the close function/method will run after the return statement
is executed.

Keep in mind:
* A deferred function's arguments are evaluated when the defer statement is evaluated.
  So if you pass in a counter i to a deferred function, and then increment i, the
  original value is what is passed.

* Deferred function calls are executed in Last In First Out order (stack) after the
  surrounding function returns.

* Deferred functions may read and assign to the returning function's named return values.
*/
func main() {
	foo()
	bar()
	fmt.Println(" ")

	defer foo()
	bar()
}

func foo() {
	fmt.Println("Foo")
}

func bar() {
	fmt.Println("Bar")
}
