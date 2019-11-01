package lectures.part2oop

object AbstractDataType extends App {
    //abstract - situations when you need to leave fields and methods unimplemented
  //abstract class - cannot be instantiated. Subclass should have the implementation
  abstract class Animal {
      val creatureType: String
      def eat: Unit
    }
  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat: Unit = println("crunch crunch")
  }

  // traits
  // Also has abstract members.
  // But classes can implement multiple traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded {
    def warmup: Unit
  }

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Croc"
    def eat: Unit = "nom nom nom"
    def eat(animal: Animal): Unit = s"I'm a croc eating a ${animal.creatureType}"

    override def warmup: Unit = println("Warming up!")
  }

  val dog = new Dog
  val croc = new Crocodile

  println(croc eat dog)

  // abstract vs traits
  /**
    * Both abstract class and traits can have ABSTRACT and NON-ABSTRACT members!
    * So what are the differences?
    *  1. Traits do not have constructor parameters
    *  2. You can inherit multiple traits
    *  3. We choose traits when we want to represent behaviour... class describe things
    */

  // Scala Type Hierarchy
  /**
    * scala.Any <---- scala.AnyRef: Is implementation of java.lang.Object; All objects inherit from it by default
    *                              <--- scala.Null
    *           <--- scala.AnyVal: Is implementation of primitives - Int, Unit, Boolean, Float,.. Rarely used in practice except for memory optimizations
    * scala.Nothing - The subtype of ALL types!
    */


}
