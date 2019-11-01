package lectures.part1basics

object ValuesVariablesType extends App {
  val x: Int = 42
  //VALS ARE IMMUTABLE
  //Used as intermediate values for bigger computations

  val y = 42
  //VAL types are optional!
  // because the compiler can infer the type

  val aString: String = "hello";
  //Semi-colons are optional in Scala!
  // needed when you write multiple expressions on the same line.

  //SCALA STYLE: no types for vals, each expression should be on separate lines.

  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val anInt: Int = x // 4 bytes
  val aShort: Short = 12345 // 2 bytes
  val aLong: Long = 9999999999L //8 bytes, need L to signify Long, otherwise compiler thinks int
  val aFloat: Float = 2.0F //need the F to signify float, otherwise compiler thinks double
  val aDouble: Double = 2.9

  //variables
  var aVariable: Int = 4
  aVariable = 5 // side effect - useful to see what the program is doing. E.g. variable reassignment, printing to console
  // functional programming prefers vals over vars
  println(x)
}
