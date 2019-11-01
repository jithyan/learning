package lectures.part1basics

object StringOps extends App {
  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2)) //Strings are 0 indexed. Prints the 3rd character of the string
  println(str.substring(7, 11)) //Substring from 7 (inclusive) to 11 (exclusive)
  println(str.split(" ").toList) // We call toList because an array doesn't print nicely
  println(str.replace(" ", "-"))
  println(str.toLowerCase)
  println(str.length)
  //All the above are Java functions

  val aNumberStr = "45"
  val aNumber = aNumberStr.toInt
  println('a' +: aNumberStr) // prepends 'a' to aNumberStr
  println(aNumberStr :+ 'z') //appends 'z' to aNumberStr
  println(str.reverse)
  println(str take 2) // takes the first two characters out of a string

  // Scala-specific: String Interpolators

  // S-Interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  //S interpolated strings expands (or injects) the strings to the expression marked with $
  //It can include more complex expressions:
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"

  // F-Interpolators
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f" //Basically allows you to format the string - prints a string, and a float 2 characters total, with minimum 2 decimal precision
  //If there is a type mismatch, the compiler will flag an error!

  //raw-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n new line"
  println(raw"$escaped") //The \n does get escaped! Injected strings will end up being escaped.
}
