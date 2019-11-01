package main

/**
Covers:
- Function declarations
- Variadic parameters
**/

import "fmt"

func main() {
	fmt.Println("main")
	fmt.Println(woo("moneypenny"))

	x, y := mouse("Ian", "Fleming")
	fmt.Println(x)
	fmt.Println(y)
	fmt.Println(" ")

	fmt.Println("Passing multiple ints as arguments to foo")
	foo(1, 2, 3, 4, 5, 6) //This becomes a slice of int!
	fmt.Println("Passing []int to foo")
	ii := []int{9, 8, 7, 6}
	foo(ii...)
}

/*
Function syntax:
	func (r receiver) identifier(parameter(s)) (return(s)) {...body...}

- Can return multiple types!
- A parameter is the defined input to a function.
- An argument is what we pass into a function when we call it.
- Everything in Go is PASS BY VALUE -- see notes section for details on Go pointers  or see http://goinbigdata.com/golang-pass-by-pointer-vs-pass-by-value
*/

func woo(s string) string {
	return fmt.Sprint("Hello from woo, ", s)
}

func mouse(fn, ln string) (string, bool) {
	a := fmt.Sprint(fn, " ", ln)
	b := true
	return a, b
}

// VARIADIC PARAMS
func foo(x ...int) {
	//if no arguments are passed, nil is passed.
	fmt.Println(x)
	fmt.Printf("%T\n", x)
	sum := 0

	for _, v := range x {
		sum += v
	}

	fmt.Println("The total is: ", sum)
}
