package exercises

abstract class GenericList[+A] {
  def add[B >: A](elem: B): GenericList[B]
  def tail: GenericList[A]
  def head: A
  def isEmpty: Boolean
  override def toString = "[" + printElements + "]"
  def printElements: String
  def map[B](transformer: A => B): GenericList[B]
  def filter(predicate: A => Boolean): GenericList[A]
  def flatMap[B](transformer: A => GenericList[B]): GenericList[B]
  def ++[B >: A](list: GenericList[B]): GenericList[B]
}

case class Cons2[+A](h: A, t: GenericList[A]) extends GenericList[A] {
  override def tail: GenericList[A] = t
  override def head: A = h
  override def isEmpty = false
  override def add[B >: A](elem: B):GenericList[B] = new Cons2(elem, this)
  override def printElements: String = h + ", " + t.printElements
  override def map[B](transformer: A => B): GenericList[B] = new Cons2[B](transformer(head), tail map transformer)

  override def filter(f: A => Boolean): GenericList[A] = {
    if (f(head)) new Cons2[A](head, tail filter f)
    else tail filter f
  }

  override def flatMap[B](f: A => GenericList[B]): GenericList[B] = f(head) ++ (tail flatMap f)

  override def ++[B >: A](list: GenericList[B]): GenericList[B] = new Cons2(h, t ++ list)
  /*
  [1, 2] ++ [3, 4, 5]
   = new Cons(1, [2] ++ [3, 4, 5])
   = new Cons(1, new Cons(2, Empty ++ [3, 4, 5]))
   = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
   */
}

case object Empty2 extends GenericList[Nothing] {
  override def tail: GenericList[Nothing]  = throw new NoSuchElementException
  override def head: Nothing = throw new NoSuchElementException
  override def isEmpty = true
  override def add[B >: Nothing](elem: B): GenericList[B] = new Cons2(elem, Empty2)
  override def printElements: String = ""
  override def map[B](transformer: Nothing => B): GenericList[B] = Empty2
  override def filter(predicate: Nothing => Boolean): GenericList[Nothing] = Empty2
  override def flatMap[B](transformer: Nothing => GenericList[B]): GenericList[B] = Empty2
  override def ++[B >: Nothing](list: GenericList[B]): GenericList[B] = list
}


object NewListTest extends App {
  val listOfInts: GenericList[Int] = new Cons2(1, new Cons2(2, new Cons2(3, Empty2)))
  println(listOfInts.toString)

  val listStr: GenericList[String] = new Cons2("1", new Cons2("2", new Cons2("3", Empty2)))

  val even: ((Int) => Boolean) = (elem: Int) => elem % 2 == 0

  val strToIntDouble: ((String) => Int) = (x: String) => Integer.parseInt(x) * 2

  println(listStr map strToIntDouble)
  println(listStr.map(_ * 2))

  println(listOfInts filter even)
  println(listOfInts.filter(_ % 2 == 0))

  println(listOfInts.flatMap((x: Int) => new Cons2(x, new Cons2(x + 1, Empty2))))

  val myTransformer: ((Int) => GenericList[Int]) =
    (x: Int) => new Cons2(x, new Cons2(x+1, Empty2))

  val myPredicate: ((Int) => Boolean) = (x: Int) => (x % 2) == 0

  val clonedList: GenericList[Int] = new Cons2(1, new Cons2(2, new Cons2(3, Empty2)))
  println(clonedList == listOfInts)
}