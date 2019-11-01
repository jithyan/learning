package lectures.part1basics

object Functions extends App {
  def aFunction(a: String, b: Int): String = a + " " + b
  def bFunction(b: String, c: Int) =
    b + ", " + c
  //Compiler can infer return type for a function
  // But best practice to define a return type

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)


  def aRepeatedFunc(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunc(aString, n - 1)
  }

  println(aRepeatedFunc("hello", 2))

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  // Needed when you want console printing, logging etc

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n-1)
  }

  //Ex 1 - Greeting
  // Ex2 - Factorial: 1*2*3*n
  // Ex3 - Fibonacci: f(n) = f(n-1) + f(n - 2), f(1) = 1, f(2) = 2
  def greeting(name: String, age: Int): String = "Hello " + name + " of age " + age + " years."

  def factorial(n: Int): Int = {
    if (n == 1)
      1
    else
      n * factorial(n - 1)
  }

  def fib(n: Int): Int = {
    if (n <= 2)
      1
    else
      fib(n - 1) + fib(n - 2)
  }

  println(greeting("Jithya", 29))
  println(fib(10))
  println(factorial(10))
}
