package lectures.part1basics

/**
  * Call by value vs call by name
  */
object CBNvsCBV extends App {
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  //Note the different syntax in the argument
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  /**
    * The functions above have the same implementation.
    * They both return Unit, which implies it doesn't care about the return value and by definition
    * have side-effects.
    *
    * When we run them, we expect:
    * v1 //nanotime at t1
    * v1
    * v2 //nanotime at t2
    * v2
    */
  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  /**
    * When you call by value, the value of System.nanoTime() is copied and passed to the function.
    * It effectively makes the body of the code:
    *   println("by value: " + 123467890L
    *
    * However when you call by name, the EXPRESSION is what is copied, effectively making the code:
    *   println("by name: " + System.nanoTime())
    *
    * Call By Name is useful for streams and for things that may fail.
    */

  //Another important example of how calling by name works
  def infinite(): Int = 1 + infinite() //Crashes with a stackoverflow error if run by itself
  def printFirstArg(x: Int, y: => Int) = println(x)

  // printFirstArg(infinite(), 34) -- CRASHES
  printFirstArg(34, infinite()) //DOES NOT CRASH - Why? Because infinite() is only evaluated if it's actually called in the code

  /**
    * SUMMARY
    * -------
    * Call by value:
    *  - Value is computed BEFORE the call
    *  - Same value is used everywhere
    *
    * Call by name:
    *   - Expression is passed literally
    *   - Expression is evaluated at every use within
    */

}
