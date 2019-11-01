package main

import "fmt"

type person struct {
	first string
	last  string
	age   int
}

type secretAgent struct {
	person        //anonymous field - unqualified type name acts as field name
	licenseToKill bool
}

type randomstruct struct {
	x, y int
}

func main() {
	p1 := person{
		first: "James",
		last:  "Bond",
		age:   32,
	}

	p2 := person{
		first: "Miss",
		last:  "Moneypenny",
		age:   29,
	}

	fmt.Println(p1)
	fmt.Println(p2.first, p2.last, p2.age)

	sa1 := secretAgent{
		person: person{
			first: "M",
			last:  "",
			age:   51,
		},
		licenseToKill: true,
	}

	sa2 := secretAgent{
		person:        p1,
		licenseToKill: true,
	}

	fmt.Println(sa1)
	//Look carefully how to access fields of a struct
	// person fields got promoted to the first level - however you can't initialize fields with values this way
	fmt.Println(sa1.first, sa1.age, sa1.last, sa1.licenseToKill)
	fmt.Println(sa2)

	// ANONYMOUS STRUCTS

	z := struct {
		first    string
		last     string
		nickname string
	}{
		first:    "james",
		last:     "bail",
		nickname: "jamie jam jam",
	}

	fmt.Println(z)
}
