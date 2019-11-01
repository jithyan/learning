package main

import "fmt"

/*
A string is an immutable sequence of zero or more bytes.
More specifically, a read-only *slice* of bytes.
Length derived from built-in len(s) function.
Indices go from 0 to len(s)-1
You cannot access the pointer of individual indices.
*/
func main() {
	s := "Hello Playground!"
	s2 := `hello " my friend \ (slash)"`

	fmt.Println(s)
	fmt.Printf("%T\n", s2)
	fmt.Printf("%v%v", s[3], s[4])

	bs := []byte(s) //Convert a string into a slice of bytes
	fmt.Println(bs)
	fmt.Printf("%T\n", bs)

	//Print the UTF-8 Code Point
	for i := 1; i < len(s); i++ {
		fmt.Printf("%#U", s[i])
	}

	fmt.Println()

	for i, v := range s {
		fmt.Printf("at index %v we have %v which is %v\n", i, v, string(v))
	}
}
