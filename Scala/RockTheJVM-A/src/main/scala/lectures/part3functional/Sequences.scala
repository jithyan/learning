package lectures.part3functional

import scala.util.Random

object Sequences extends App {
  /**
    * Sequences
    * ----------
    *  A general interface for data structures that:
    *   - have a well defined order
    *   - can be indexed
    *
    *  Operations supported:
    *   - apply, iterator, length, reverse for indexing and iterating
    *   - concatenation, appending, prepending
    *   - grouping, sorting, searching, slicing, zipping
    */

  val aSequence = Seq(1,2,3,4)
  println(aSequence) //is actually a List! Declared type is Sequence, the subclass is List
  println(aSequence.reverse)
  println(aSequence(2)) // Apply method with 2 - retrieves a value at the specified index
  println(aSequence ++ Seq(5,6,7))
  println(aSequence.sorted) //this works without extra stuff if the type is by default ordered - covered only in advanced Scala

  /**
    * Ranges - also sequences
    */

  val aRange: Seq[Int] = 1 to 3 //non-inclusive
  aRange.foreach(println)

  (1 to 5).foreach(x => println("Hello " + x))


  /**
    * List
    * -----
    * sealed abstract class List[+A]
    * case object Nil extends List[Nothing]
    * case class ::[A](val hd: A, val tl: List[A]) extends List[A]
    *
    * List is a LinearSeq immutable linked list:
    *   - head, tail, isEmpty: O(1)
    *   - most operations are O(n): length, reverse
    *
    * Sealed - has 2 subtypes:
    *  - Nil (empty)
    *  - ::    *
    */

  val aList = List(1,2,3)
  val prepend = 42 :: aList
  println(prepend)
  val prepend2 = 43 +: prepend

  val append = aList :+ 89
  println(append)

  val apples5 = List.fill(5)("apple") // "fill" is a curried function that takes in a number n and a value v
                                      // that constructs a list of n values v.
  println(apples5)

  println(aList.mkString("-|-"))   //mkString concatenates all the values with the argument between them

  /**
    * Array
    *
    * final class Array[T] extends java.io.Serializable with java.lang.Cloneable
    *
    * The equivalent of simple Java arrays:
    *   - can be manually constructed with predefined lengths
    *   - can be mutated (updated in place)
    *   - are interoperable with Java's T[] arrays
    *   - indexing is fast
    */

  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[String](3) //Allocates space for 3 elements of type String
  println(threeElements)
  println(numbers)
  threeElements.foreach(println)

  //mutation
  numbers(2) = 0 //syntax sugar for numbers.update(2, 0) -- for mutable objects
  println(numbers.mkString(", "))

  //arrays and sequences
  val numbersSeq: Seq[Int] = numbers //Implicit conversion -- advanced topic!!!
  //underline by the IDE indicate implicit conversion is happening
  println(numbersSeq) //is a WrappedArray


  /**
    * Vector
    * -------
    *
    * The default implementation for immutable sequences
    *   - effectively constant indexed read and write: O(log32(n))
    *   - fast element addition: append/prepend
    *   - implemented as fixed-branched trie (branch factor 32
    *   - good performance for large sizes
    */
  val noElements = Vector.empty
  val nums = noElements :+ 1 :+ 2 :+ 3   //Vector(1,2,3)
  val modified = numbers updated (0,7) //Vector(7,2,3)

  val vector: Vector[Int] = Vector(1,2,3)

  //vectors vs list
  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection updated (r.nextInt(maxCapacity), r.nextInt) //update at index within capacity with random int
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // + keeps reference to tail
  // - updating element in the middle is costly
  println(getWriteTime(numbersList))

  // + depth of the tree is small
  // - needs to replace a 32 element chunk
  println(getWriteTime(numbersVector))

  //Vector is default implementation of sequence as it's faster for most cases !
}