package lectures.part3functional

object MapFlatMapFilterFor extends App {

    val list = List(1,2,3) //Calling apply method in the companion object

    //map
  println(list.map(_ + " is a number"))

  //filter
  println(list filter (_ % 2 == 0))

  //flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list flatMap toPair)

  /**
    * map takes a function that is 1 -> 1.
    * flatMap takes a function that is  1 -> N. The final result is a flat list.
    */

  //print all combinations between two lists
  // this is how you convert iterations on structures in procedural to functional using flatMap and map
  val numbers = List(1,2,3,4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")

  val combinations = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + "-" + color)))
  println(combinations)


  //FOR COMPREHENSIONS - how to shorten long chains of maps/flatmaps

  val forCombinations = for {
    n <- numbers
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  // forCombinations == combinations
  // preferred in practice !

  val forCombinationsWithGuards = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  for {
    n <- numbers
  } println(n)

  //syntax overload - alternative style
  list.map { x =>
    x * 2
  }

  // Exercises:
  /*
  1. Go to FList and use for comprehensions
  2. Implement a small collection of at most ONE element - Maybe[+T]
      -map, flatMap, filter
   */

}
