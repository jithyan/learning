package lectures.part3functional

object HoFsAndCurries extends App {

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null

  // examples of HoFs:
  // map, flatMap, filter (because they take functions as parameters)
  // -- However HoFs include functions that return functions

  //function that applies a functin n times over a value x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x))) --> classic HoF
  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0)
      x
    else
      nTimes(f, n-1, f(x))
  }

  val plusOne = (x: Int) => x + 1
  val plusOne2: (Int => Int) = _ + 1
  println(nTimes(plusOne, 10, 1))

  // A better way of doing nTimes

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if (n < 1) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))
  }

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))


  // curried functions = functions with multiple parameter lists
  val superAdder: Int => Int => Int = (x: Int) => (y: Int) => x + y

  println(superAdder(3)(10))

  //functions with multiple parameter lists
  // these act like curried functions !
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  // -- Have to specify type!
  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat:(Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  /* Exercises

  1. Expand GenericList
    - foreach method A => Unit (applies function to every element of the list
        [1,2,3].foreach(x => println(x))

    - sort function ((A, A) => Int)) => MyList
        [1, 2, 3].sort((x, y) => y - x) => [3, 2, 1]

    - zipWith function (list, (A, A) => B) => MyList[B]
        [1,2,3].zipWith([4, 5, 6], x * y) => [ 1*4, 2*5, 3*6] = [4, 10, 18]

    - fold (curried function)
        fold(start)(function) => a value
        [1, 2, 3].fold(0)(x + y) = 6

   2. Define a method: toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
      fromCurry(f: (Int => Int => Int)) => (Int, Int) => Int

   3. Compose(f, g) => x => f(g(x))
      andThen(f, g) => x => g(f(x))

      See FList for 1. solution

   */

  //2. toCurry

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) =
    x => y => f(x, y)

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int =
    (x, y) => f(x)(y)

  def compose(f: Int => Int, g: Int => Int): Int => Int =
    x => f(g(x))

  def genericCompose[A, B, T](f: A => B, g: T => A): T => B =
    x => f(g(x))

  def andThen(f: Int => Int, g: Int => Int): Int => Int =
    x => g(f(x))

  def genericAndThen[A, B, C](f: A => B, g: B => C): A => C =
    x => g(f(x))
}
