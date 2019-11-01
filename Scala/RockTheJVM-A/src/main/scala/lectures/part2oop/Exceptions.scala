package lectures.part2oop

object Exceptions extends App {
  // Exception are expressions
  //val aWeirdValue = throw new NullPointerException
  //however aWeirdValue holds scala.Nothing!

  // Throwing exceptions return scala.Nothing

  //Throwable classes extend the Throwable class
  //Exception (went wrong with the program e.g. NullPointer) and Error (something went wrong with the system - e.g. Stack overflow
  // are the major Throwable subtypes

  // 2. Catching Exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  try {
    //code that might throw
    getInt(true)
  } catch {
      case e: RuntimeException => println("Caught a runtime exception: " + e.getMessage)
  } finally {
    //printed no matter what
    //Optional
    println("finally!")
  }

  val potentialFail = //The compiler will say this is an Int!
  // For the previous try catch block,
  // the compiler would say AnyVal - because it could be either 42 returned from the method, or the println (Unit)
  // from the catch block.
  try {
    getInt(true)
  } catch {
    case e: RuntimeException => 43
  } finally {
    // Does not influence the return type
    // Use finally only for side-effects - eg. logging
    println("finally2!")
  }

  println(potentialFail) // Will print 43


  // Define your own Exceptions
  class MyException extends Exception
}
