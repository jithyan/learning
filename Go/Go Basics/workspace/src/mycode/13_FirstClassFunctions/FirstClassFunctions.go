package main

/*
This covers:
 - Anonymous functions
 - Function expressions
 - Returning functions
 - Callback
*/

import "fmt"

func main() {
	//1. Anonymous function
	fmt.Println("Anonymous function")
	func(x int) {
		fmt.Println("The meaning of life is", x)
	}(42)
	//Above is a function with no identifier define, with the arguments passed after its final
	//brace

	//2. Function expression
	fmt.Printf("\nFunction expression\n")
	f := func(x int) {
		fmt.Println("My first func expression, has number", x)
	} // First class functions can be used like any other variables - func is a type like any other type
	fmt.Printf("%T\n", f)
	f(24)

	//3. Returning another function
	fmt.Printf("\nReturning a function\n")
	x := bar()
	fmt.Printf("%T\n", x)
	fmt.Println(x())

	//4. Callback
	// Callbacks are when you pass a function in as an argument to another function.
	isEven := func(num int) bool { return (num%2 == 0) }
	listOfInt := []int{1, 2, 3, 4, 5, 6}
	s := sum(isEven, listOfInt...)
	s2 := sum(func(num int) bool { return true }, listOfInt...)
	fmt.Println("Sum of even numbers is:", s)
	fmt.Println("Sum of all numbers is:", s2)
}

func bar() func() int {
	return func() int {
		return 451
	}
}

func sum(fTest func(i int) bool, ii ...int) int {
	total := 0
	for _, v := range ii {
		if fTest(v) == true {
			total += v
		}
	}

	return total
}
