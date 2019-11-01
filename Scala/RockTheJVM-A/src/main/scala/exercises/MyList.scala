package exercises

abstract class MyList {
  /*
  Singly linked list that returns integers
  Methods:
    head = first integer in the list
    tail = remainder of the list
    isEmpty
    add - receives an integer and returns a new list
    override toString to return a string representation of the list
   */
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList {
  /// ??? - /This returns scala.Nothing, and if the method is called, it throws a not implemented error
  override def head: Int = throw new NoSuchElementException // Throw expressions return nothing

  override def tail: MyList = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add(element: Int): MyList = new Cons(element, Empty)

  override def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  override def head: Int = h //This returns scala.Nothing, and if the method is called, it throws a not implemented error

  override def tail: MyList = t

  override def isEmpty: Boolean = false

  override def add(element: Int): MyList = new Cons(element, this)

  override def printElements: String =  {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }
}

object ListTest extends App {
  val list = new Cons(1, Empty)
  println(list.head)

  val list2 = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list2.tail.tail.head)

  println((list add 4).head)

  println(list2.toString)
}
