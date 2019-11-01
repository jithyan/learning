package lectures.part1basics

object DefaultArgs extends App {
  def trFact(n: Int, acc: Int): Int = if (n <= 1) acc else trFact(n-1, n*acc)
  trFact(10, 1)

  //Default value
  def trFactDefArg(n: Int, acc: Int = 1): Int = if (n <= 1) acc else trFact(n-1, n*acc)

  // You can ommit the second argument
  trFactDefArg(10)

  //But the folllowing won't work - it confuses the compiler (when you omit leading arguments)
  def namedArgs(message: String = "Hello World", repeat: Int = 1): Unit = {
      println(message)
      if (repeat > 1)
        namedArgs(message, repeat - 1)
  }
  //namedArgs(1) -- WONT WORK

  //Solution: Use named args!
  namedArgs(repeat = 3)
  namedArgs(message = "Goodbye Everyone!")
}
