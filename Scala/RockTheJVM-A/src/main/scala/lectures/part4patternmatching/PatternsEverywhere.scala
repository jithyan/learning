package lectures.part4patternmatching

object PatternsEverywhere extends App {
  //big idea #1 - Catches are actually pattern matches

  try {

  } catch {
    case e: RuntimeException => "A runtime exception"
    case e: NullPointerException => " A null exception"
    case _ => " other exception"
  }

  // big idea #2 - Generators are also based on pattern matching

  val list = List(1,2,3)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield 10 * x

  val listTuples = List((1,2),(3,4))

  val filterTuples = for {
    (first, second) <- listTuples
  } yield first * second
  //works with case classes, :: operators, ..


  // big idea #3 - Multiple value definitions based on pattern matching
  val t = (1,2,3)
  val (a,b,c) = t
  println(a)
  println(b)
  println(c)

  // Not limited to tuples!
  val head :: tail = list
  println(head)
  println(tail)

  // big idea #4 - Partial Functions
  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "dun care"
  }// a partial function literal - advanced!
  // based on pattern matching


}
