package exercises

abstract class BST {
  def isEmpty: Boolean
  def contains(item: Int): Boolean
  def add(item: Int): BST
  def toString: String
  def printTree: Unit
}

case class Node(left: BST, right: BST, data: Int) extends BST {
  def apply(left: BST, right: BST, data: Int): Node = new Node(left, right, data)

  override def toString: String = s" $data "

  override def isEmpty(): Boolean = false

  override def contains(item: Int): Boolean = {
    if (data == item)
      true
    else if (data < item)
      left.contains(item)
    else
      right.contains(item)
  }

  override def add(item: Int): BST = {
    if (item <= data)
      Node(left.add(item), right, data)
    else
      Node(left, right.add(item), data)
  }

  override def printTree: Unit = {
    left.printTree
    println(toString)
    right.printTree
  }
}

case object EmptyNode extends BST {
  override def isEmpty(): Boolean = true
  override def contains(item: Int): Boolean = false
  override def add(item: Int): BST = Node(EmptyNode, EmptyNode, item)
  override def printTree: Unit = Unit
}

object BstTest extends App {
  val bst = Node(EmptyNode, EmptyNode, 5).add(3).add(7).add(1)
  bst.printTree
}
