package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def fac(n: Int): Int = if (n <= 1) 1 else n * fac(n - 1)

  def tailFac(n: Int): Int = {
    @scala.annotation.tailrec
    def aux(x: Int, acc: Int): Int = if (x <= 1) acc else aux(x - 1, acc = x * acc)
    //The above is a tail recursive function
    //Use recursive call as the LAST expression
    //By adding the annotation, the compiler will complain if not tail recursive
    aux(n, 1)
  }


  def concat(str: String, n: Int): String = {
    @tailrec
    def aux(acc: String, str: String, n: Int): String = if (n == 0) acc else aux(acc + str, str, n - 1)
    aux("", str, n)
  }
  println(concat("donkey", 5))
}
