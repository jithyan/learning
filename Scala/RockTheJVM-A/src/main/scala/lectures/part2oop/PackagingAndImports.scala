package lectures.part2oop// not an expression

//Name aliasing
import lectures.part2oop.OOBasics.{Writer => DanielWriter} //useful if you have multiple classes of the same name
// the other option is to use fully qualified names

//To import all the classes (not best practice unless you actually need it:
import java.sql._

object PackagingAndImports extends App {

    //package members are accessible by their simple name
  val writer = new DanielWriter("Daniel", "RockTheJVM", 2018)

  // packages are in hierarchy
  // matching folder structure

  //Scala specific
  // package object - these were created to address the problem of wanting to access universal constants
  // or methods without accessing classes
  // You create them by right clicking a package and clicking new package object
  /**
    * 1. You can only have one package object per package
    * 2. The object will have the same name as the package
    * 3. The file name of the object will be package.scala
    * 4. You define constants or methods in the package object and use them by their simple name elsewhere in the package.
    */

  sayHello
  println(SPEED_OF_LIGHT)
  // however package objects are rarely used in practice

  //default imports:
  // java.lang - String, Object, Exception..
  // scala - Int, Nothing, Function...
  // scala.Predef - println, ???

}
