package main

import "fmt"

func main() {
	/*
		   x := type{values} -- composite literal

			Essential reading on composite literals:
			https://golang.org/doc/effective_go.html#composite_literals

			Composite literals can be created for arrays, slices and maps, with
			the field being indices or map keys as appropriate.
	*/

	x := []int{1, 2, 3, 4}
	fmt.Println(x)
	fmt.Println(len(x))
	fmt.Println(x[2])
	fmt.Println(x[:])   //slicing
	fmt.Println(x[1:])  // index 1 to end (indexes are 0 based)
	fmt.Println(x[1:3]) // 1 to 3 (not inclusive)

	// a SLICE allows you to group together VALUES of the same TYPE
	/*
		If you're looping over an array, slice, string or map, reading from a channel,
		you can use the RANGE clause
	*/

	for i, v := range x {
		fmt.Println(i, v)
	}
	for i := 0; i < 4; i++ {
		fmt.Println(i, x[i])
	}

	// APPENDING
	// append function has signature:
	/*
					   func append(slice []T, elements ...T) []T

				      So it takes in a slice of type T and any number of elements (indicated by ...).
				      The elements are appended to the end of the slice.  If it has sufficient capacity,
				      the destination is resliced to accommodate the new elements.
				      If it does not, a new underlying array will be allocated.
				      Append returns the updated slice.
		            It is therefore necessary to store the result of append, often in the variable holding the slice itself.

		            NOTE: ... means "variadic" parameter
	*/

	x = append(x, 99, 88, 77)
	y := []int{900, 800, 700}

	x = append(x, y...)
	fmt.Println(x)

	// removing elements from a slice
	x = append(x[:3], x[5:]...)
	fmt.Println("Deleted slice:")
	fmt.Println(x)

	/*
			   Slices have a dynamically resizing underlying array.
		      If you know the size in advance, you can use "make" to allocate the array.

		      "make" only applies to maps, slices and channels, and does not return a pointer.
		      To obtain an explicit pointer, use "new" or take the address of a variable explicitly.

		      make takes in a type, the length and capacity.
	*/

	var v []int = make([]int, 10, 100)
	// The above initializes an array of length 100 and creates a slice pointing to the first 10 elements.

	//idiomatic go (omitting length)
	s := make([]int, 100)

	fmt.Println(v)
	fmt.Println(len(v))
	fmt.Println(cap(v))
	fmt.Println(len(s))

	//multi-dimensional slices
	xp := [][]int{x, y}
	fmt.Println(xp)

}
