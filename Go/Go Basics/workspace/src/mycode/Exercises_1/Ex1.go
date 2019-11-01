package main

import "fmt"

func main() {
	// Ex1
	// Using a composite literal, create an array that holds 5 ints, range over it to print the values out
	// and use format printing to print out the type of the array.

	x := [5]int{1, 2, 3, 4, 5}

	for _, v := range x {
		fmt.Printf("%v (%T)\n", v, v)
	}

	// Ex2 - Same as Ex1  slices instead
	sliceX := []int{1, 2, 3, 4, 5}
	fmt.Printf("%T", sliceX)

	// Ex 4: Append 53, 54, 55 to the above slice, and then append the slice y to that slice
	sliceX = append(sliceX, 53, 54, 55)
	y := []int{56, 57, 58, 59, 60}
	sliceX = append(sliceX, y...)
	fmt.Println(sliceX)

	// Ex 7: Create a slice of a slice of string
	s1 := []string{"james", "bond", "shaken not stirred"}
	s2 := []string{"miss", "moneypenny", "hellooo james"}
	ss := [][]string{s1, s2}
	fmt.Println(ss)
}
