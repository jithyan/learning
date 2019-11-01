package main

import "fmt"

func main() {
	var x [5]int // Array of ints, length 5
	// WE DONT REALLY USE ARRAYS IN GO!
	// Slices are used instead.

	for i := range x {
		x[i] = i * 10
	}

	fmt.Println(x)
}
