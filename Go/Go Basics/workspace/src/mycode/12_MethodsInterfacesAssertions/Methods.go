package main

/*
This covers:
 - Methods
 - Interfaces
 - Assertions
*/

import "fmt"

type Person struct {
	first string
	last  string
}

type SecretAgent struct {
	Person
	licenseToKill bool
}

/*
How do you define methods?
Remember a function is defined as:
	func (r receiver) identifier(parameter(s)) (return(s)) {code}

"receiver" is the type which the function is attached to - making it a method
*/

func (s SecretAgent) speak() {
	fmt.Println("The secret agent", s.first, s.last, "has spoken")
}

func (p Person) speak() {
	fmt.Println("I am an ordinary person named", p.first, p.last)
}

// DEFINING INTERFACES - any method named speak implements this interface!
type human interface {
	speak()
}

func main() {
	// a VALUE can be of more than one TYPE
	// Therefore, sa1 is both a secret agent and a human (because a secret agent can speak)
	sa1 := SecretAgent{
		Person: Person{
			"James",
			"Bond",
		},
		licenseToKill: true,
	}
	sa1.speak()

	fmt.Println(" ")
	bar(sa1)
	bar(sa1.Person)
}

func bar(h human) {
	fmt.Println("I called a human he says:")
	h.speak()

	//Assertions
	// Not you C assertions!
	// Basically casting.

	switch h.(type) {
	case Person:
		fmt.Println("I'm a assertion example for person:", h.(Person).first)

	case SecretAgent:
		fmt.Println("I'm an assertion example for secret agent:", h.(SecretAgent).first)
	}
}
