package lectures.part4patternmatching

import scala.util.Random

object PatternMatching extends App{

  //pattern matching is like switch on steroids
  val random = new Random()
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "one"
    case 2 => "two"
    case 3 => "three"
      //and so on
    case _ => "something else"
      // _ is a wildcard - it will match anything
  }
  //pattern matching tries to match a value with a pattern

  /* Uses of pattern matching */
  // 1. To decompose values - especially when used in conjuction with case classes
  // Case classes have the capability of being deconstructed/extracted in pattern matching
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) => if (a < 21) s"Hi I'm $n and I can't drink in the US"
    case Person(n, a) => s"Hi I'm $n and I am $a years old"
    case _ => "I don't know who I am"
  }
  // You can not only pattern match against values, but also a case class !

  /*
  1. Cases are matched in order
  2. If no match is found, you get a match error - so make sure you CYA with _
  3. The type returned by the case expression is the lowest common ancestor of all the types in the pattern,
    I.e., if for one pattern you return String and the other Int, the expression will return Any
  4. PM works really well with case classes!
   */

  //PM on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Bulldog")
  animal match {
    case Dog(someBreed) => println(s"Hi I'm a dog of breed $someBreed")
  }// This will generate a compiler error saying you haven't covered all posibilities
  // So sealed classes help CYA

  /*
  Exercise
  Write a function that uses PM
  Takes an Expr and writes it in human readable form

  E.g.
  Sum(Number(2),Number(3)) = 2 + 3
  Sum(Number(2), Number(3), Number(4)) = 2 + 3 + 4
  Prod(Sum(Number(2),Number(3)), Number(3)) = (2 + 3) * 3
  Sum(Prod(Number(1), Number(2)), Number(3)) = 1 * 2 + 3
   */
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Product(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Product(e1, e2) => {
      def maybeShowParentheses(e: Expr) = e match {
        case Product(_,_) => show(e)
        case Number(_) => show(e)
        case _ => "(" + show(e) + ")"
      }
      maybeShowParentheses(e1) + " * " + maybeShowParentheses(e2)
    }
  }
  println(show(Sum(Number(2),Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Product(Sum(Number(2),Number(3)), Number(3))))
  println(show(Sum(Product(Number(1), Number(2)), Number(3))))
}
