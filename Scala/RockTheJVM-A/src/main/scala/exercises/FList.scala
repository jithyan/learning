package exercises

import scala.annotation.tailrec

abstract class FList[+A] {
  def add[B >: A](elem: B): FList[B]
  def tail: FList[A]
  def head: A
  def isEmpty: Boolean
  override def toString = "[" + printElements + "]"
  def printElements: String
  def map[B](transformer: A => B): FList[B]
  def filter(predicate: A => Boolean): FList[A]
  def flatMap[B](transformer: A => FList[B]): FList[B]
  def ++[B >: A](list: FList[B]): FList[B]

  //HoFs
  def foreach(f: A => Unit) = {
    @tailrec
    def foreachHelper(g: A => Unit, list: FList[A]): Unit = {
      if (list.isEmpty)
        Unit
      else {
        f(list.head)
        foreachHelper(g, list.tail)
      }
    }
    foreachHelper(f, this)
  }

  def foreachAlt(f: A => Unit)

  def sort(comp: ((A, A) => Int)): FList[A] = {
    //@tailrec
    def insertionSort(sortedL: FList[A], elem: A): FList[A] = {
      if (sortedL isEmpty)
        FCons[A](elem, FEmpty)
      else if (comp(elem, sortedL.head) <= 0)
        FCons[A](elem, sortedL)
      else
        FCons(sortedL.head, insertionSort(sortedL.tail, elem))
    }

    @tailrec
    def sortHelper(listToSort: FList[A], sortedList: FList[A]): FList[A] = {
      if (listToSort isEmpty)
        sortedList
      else if (sortedList isEmpty)
        sortHelper(listToSort.tail, insertionSort(FEmpty, listToSort.head))
      else
        sortHelper(listToSort.tail, insertionSort(sortedList, listToSort.head))
    }

    sortHelper(this, FEmpty)
  }

  def sortAlt(compare: (A,A) => Int): FList[A]

  def zipWith[B, C](zip: (A, B) => C, otherList: FList[B]): FList[C] = {
    def zipWithHelper(zippedList: FList[C], listA:FList[A], listB:FList[B]): FList[C] = {
      if ((listA isEmpty) || (listB isEmpty))
        zippedList
      else
        zipWithHelper(new FCons[C]((zip(listA.head, listB.head)), zippedList), listA.tail, listB.tail)
    }

    zipWithHelper(FEmpty, this, otherList)
  }

  def zipWithAlt[B, C](list: FList[B], zip: (A, B) => C): FList[C]

  def fold[B](start: B)(operator: (B, A) => B): B

}

case class FCons[+A](h: A, t: FList[A]) extends FList[A] {
  override def tail: FList[A] = t
  override def head: A = h
  override def isEmpty = false
  override def add[B >: A](elem: B):FList[B] = new FCons(elem, this)
  override def printElements: String = h + ", " + t.printElements
  override def map[B](transformer: A => B): FList[B] = new FCons[B](transformer(head), tail map transformer)

  override def filter(f: A => Boolean): FList[A] = {
    if (f(head)) new FCons[A](head, tail filter f)
    else tail filter f
  }

  override def flatMap[B](f: A => FList[B]): FList[B] = f(head) ++ (tail flatMap f)

  override def ++[B >: A](list: FList[B]): FList[B] = new FCons(h, t ++ list)

  def apply[A](h: A, t: FList[A]): FCons[A] = new FCons[A](h, t)
  /*
  [1, 2] ++ [3, 4, 5]
   = new Cons(1, [2] ++ [3, 4, 5])
   = new Cons(1, new Cons(2, Empty ++ [3, 4, 5]))
   = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
   */
  override def fold[B](start: B)(operator: (B, A) => B): B = {
    val newStart = operator(start, h)
    t.fold(newStart)(operator)
  }

  override def foreachAlt(f: A => Unit): Unit = {
    f(h)
    t.foreachAlt(f)
  }

  override def sortAlt(compare: (A, A) => Int): FList[A] = {
    def insert(x:A, sortedList: FList[A]): FList[A] = {
      if (sortedList.isEmpty)
        FCons(x, FEmpty)
      else if (compare(x, sortedList.head) <= 0)
        FCons(x, sortedList)
      else
        FCons(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sortAlt(compare)
    insert(h, sortedTail)
  }

  override def zipWithAlt[B, C](list: FList[B], zip: (A, B) => C): FList[C] = {
    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else FCons(zip(h, list.head), t.zipWithAlt(list.tail, zip))
  }
}

case object FEmpty extends FList[Nothing] {
  override def tail: FList[Nothing]  = throw new NoSuchElementException
  override def head: Nothing = throw new NoSuchElementException
  override def isEmpty = true
  override def add[B >: Nothing](elem: B): FList[B] = new FCons(elem, FEmpty)
  override def printElements: String = ""
  override def map[B](transformer: Nothing => B): FList[B] = FEmpty
  override def filter(predicate: Nothing => Boolean): FList[Nothing] = FEmpty
  override def flatMap[B](transformer: Nothing => FList[B]): FList[B] = FEmpty
  override def ++[B >: Nothing](list: FList[B]): FList[B] = list
  def fold[B](start: B)(operator: (B, Nothing) => B): B = start

  override def foreachAlt(f: Nothing => Unit): Unit = () //Unit value = ()
  override def sortAlt(compare: (Nothing, Nothing) => Int): FList[Nothing] = FEmpty

  override def zipWithAlt[B, C](list: FList[B], zip: (Nothing, B) => C): FList[C] = {
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else FEmpty
  }
}


object Tester extends App {
  val listOfInts: FList[Int] = new FCons(1, new FCons(2, new FCons(3, FEmpty)))
  println(listOfInts.toString)

  val listStr: FList[String] = new FCons("1", new FCons("2", new FCons("3", FEmpty)))

  val even: ((Int) => Boolean) = (elem: Int) => elem % 2 == 0

  val strToIntDouble: ((String) => Int) = (x: String) => Integer.parseInt(x) * 2

  println(listStr map strToIntDouble)
  println(listStr.map(_ * 2))

  println(listOfInts filter even)
  println(listOfInts.filter(_ % 2 == 0))

  println(listOfInts.flatMap((x: Int) => new FCons(x, new FCons(x + 1, FEmpty))))


  val myTransformer: ((Int) => FList[Int]) =
    (x: Int) => new FCons(x, new FCons(x+1, FEmpty))

  val myPredicate: ((Int) => Boolean) = (x: Int) => (x % 2) == 0

  val clonedList: FList[Int] = new FCons(1, new FCons(2, new FCons(3, FEmpty)))
  println(clonedList == listOfInts)

  println("foreach test")
  listOfInts.foreach(println)

  println("Sort test")
  println(listOfInts.sort((x: Int, y: Int) => y - x))
  println(listOfInts.sort((x: Int, y: Int) => x - y))

  println("ZipWith test")
  val zip: (Int, Int) => Int = _ * _
  println(listOfInts.zipWith(zip, listOfInts))


  //for comprehensions
  println(
    for {
      n <- listOfInts
      string <- listStr
    } yield n + "-" + string
  )
  //In order to use for comprehensions, you need to implement map, flatMap and filter


}