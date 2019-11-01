package main

import "fmt"

//variable declaration
var x bool
var y = 42
var z = "Shaken, not stirred"
var a = `James said "Shaken , \ 
not stirred"` //String literal - will include ANYTHING except backticks

//zero values
var zeroi int
var empty string

//Constants
const c int32 = 9
const (
	c1 int32   = 32
	c2 string  = "Hi"
	c3 float32 = 2.5
)

/* CREATING YOUR OWN TYPE */
type hotdog int // A type called "hotdog" that is an int
var b hotdog

/* NUMERIC types
uint8
uint16
uint32
uint64

int8
int16
int32
int64

float32
float64 -- use this as default

complex64
complex128

byte alias for uint8
rune alias for uint32 -- (in utf32 for one char)

-- Implementation Specific--
uint -- either 32 or 64
int -- either 32 or 64
uintptr -- an unsigned integer large enough to store the uninterpreted bits of a pointer value

Note:
Conversions are required between all types - even int and int32 (not so for aliases)
*/

func main() {
	x = true
	fmt.Println(x)
	fmt.Println(y)
	fmt.Printf("%T\n", y) //%T is the variable type
	fmt.Println(z)
	fmt.Printf("%T\n", z)

	println(zeroi) //0
	println(empty) //""
	// nil for pointers, functions, interfaces, slices, channels, maps

	//Use short hand as much as possible
	//Use var for zero value and package level scope

	//Creating your own type
	b = 42
	fmt.Printf("%T is b", b)

	var a int
	fmt.Println(a)
	//a = b won't work! since different types
	// Use conversion:
	a = int(b)

	x := 2.4

	i := int(x)
	fmt.Println(i)
}
