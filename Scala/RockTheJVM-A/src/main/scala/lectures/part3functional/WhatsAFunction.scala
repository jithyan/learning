package lectures.part3functional

object WhatsAFunction extends App {

  // use and work with functions as first class elements
  // i.e. use functions like we work with plain values

  // problem: oop - everything is a class
  // The JVM is designed for OOP
  // So first class elements are objects

  //Solution: All Scala functions are objects!
  // There are "Function" traits, which support up to 22 params
  // These traits look like:
  //
  // trait Function1[-A, +B] {
  //    def apply(element: A): B
  // }
  //
  // So Function1[A,B], takes a function that has 1 param of type A, and returns type B
  // Function2[A,B,C], takes 2 params A,B and returns C
  // Function3[A,B,C,D] = ((A, B, C) => D)
  //                         (Syntactic Sugar)
  val adder1: Function2[Int, Int, Int] = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  val adder2: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }
  // and so on, up to Function22

  /*
  1. a function that takes two strings and concatenates them.
  2. Transform MyPredicate and MyTransformer into function types
  3. Define a function which takes an int and returns another function which takes an int and returns an int.
     - what's the type of this function
     - how do you do it
   */

  //ex 1
  val concat: ((String, String) => String) = (x, y) => s"$x$y"
  println(concat("hello", " goodbye"))

  val superAdder: ((Int) => (Int) => Int) = (x: Int) => (y: Int) => x + y

  val adder3 = superAdder(3)
  println(adder3(4))

  println(superAdder(3)(4)) //Curried function!

  // higher order functions:
  // they either receive functions as parameters or
  // return other functions as a result
}
