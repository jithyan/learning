package main

import "fmt"

//Entry point

var z = 42 //package level visibility
var a int  //declare there is a variable with the identifier "a" and is of type int
//a's value is 0

func main() {
	// := short declaration operator
	// DECLARE a variable and ASSIGN a value of a certain type
	// CAN ONLY BE USED WITHIN A FUNCTION BODY!
	_, err := fmt.Println("Hello, World!")
	fmt.Println(err)
	foo()
	loop()

	//Use VAR to declare a variable outside a function body
	var y = 43
	fmt.Println(y)
	fmt.Println(z)
	fmt.Println(a)
}

func loop() {
	for i := 0; i < 10; i++ {
		if i%2 == 0 {
			fmt.Println(i)
		}
	}
}

func foo() {
	fmt.Println("I'm in foo!")
}
