package lectures.part3functional

class AnonymousFunctions extends App {

    val doubler = new Function1[Int, Int] {
      override def apply(x: Int) = x * 2
    } // OOP WAY STILL

  // Functional way - LAMBDA (anonymous function)
  // these lambdas are from calculus!
  val doubler2 = (x: Int) => x * 2
  val doubler3: Int => Int = x => x * 2

  //multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  //no params
  val justDoSomething = () => 3
  val justDoSomething2: () => Int = () => 3

  println(justDoSomething)
  println(justDoSomething()) //actually prints the result of function
  // WITH LAMBDAS, YOU MUST INCLUDE PARANTHESES

  //curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // More sugar

  val niceIncrementer: Int => Int = (x: Int) => x + 1
  val niceIncrementer2: Int => Int = _ + 1

  val niceAdder: (Int, Int) => Int = _ + _ //equiv to (a,b) = a + b
  //When "_" is used, the order is important!!! Also the type declaration is important

  /*
  1. MyList: replace all FunctionX calls with lambas
  2. Rewrite special adder as an anonymous function
   */

}
