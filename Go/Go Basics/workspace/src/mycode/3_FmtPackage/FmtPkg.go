package main

import "fmt"

/*
Package fmt implements formatted I/O with functions analogous to C's printf and scanf.

General:
%v - the value in default format
%#v - Go syntax representation of the value
%T - type of the value
%% - a literal percent sign

Boolean:
%t - the word true or false

Integer:
%b - base 2
%c - the char represented by the corresponding unicode code point
%d - base10
%o - base8
%x - base 16 with letters in lower case
%X - base 16 with letters in upper case

Floating point and complex:
%f - decimal floating point but no exponent

String:
%s - uninterpreted bytes of strng or slice
%q - double quoted string safely escaped with Go syntax

Pointer:
%p base 16 notation, leading 0x

*/

var y = 42

func main() {
	/* Print prints to standard output */
	fmt.Printf("%b\n", y) //HAVE TO USE PRINTF not PRINTLN!!!
	fmt.Printf("%#x\n", y)
	fmt.Printf("%x \t %X \t %T \t %#x", y, y, y, y)

	/* Sprint does a "string" print */
	s := fmt.Sprintf("%x \t %X \t %T \t %#x", y, y, y, y) //returns a formatted string
	fmt.Println(s)

	/* Fprint - printing to a file - anything that implements the Writer interface */

}
