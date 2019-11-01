package lectures.part2oop

object Generics extends App{
  //Generic type enclosed in square brackets
  class MyList[A] {

  }

  trait MyBehaviour[A,B,C] {

  }

  class MyMap[K,V] {

  }

  val listOfIntegers  = new MyList[Int]
  val listOfStrings = new MyList[String]

  //Generic Methods
  object MyList //Cannot be Type Parameterized
  {
    //methods can be type parameterized
    def empty[A]: MyList[A] = ???
  }

  class exp {
    def something[A]:Int = 3
    def some[A](elem: A): A = elem
  }

  //variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal:Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION

  // 2. NO = INVARIANCE
  class InvariantList[A] //MyList[A] defined earlier is an invariant list
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal] //InvariantList[Cat] won't work!

  //3. CONTRAVARIANCE
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]
  // Contravariance does not make any intuitive sense for Lists
  // Let's use another example:

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  //bounded types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car
  //val newCage = new Cage(new Car)// DOES NOT COMPILE! Car isn't a subtype of Animal

  class Cage2[A >: Animal] //only accepts supertypes of animal!

  /**
    * We want to implement a COVARIANT List, as lists should be Covariant
    */

  class MyCovList[+A] {
    /**
      * The following signature throws an error:
    def add(elem: A): MyList[A] = ???

      Why??? Because we need to answer the question we asked earlier:
      animalList.add(new Dog) - is this acceptable?

      To do that, we use the following signature:
      */
    def add[B >: A](element: B): MyList[B] = ???
    // This basically says the method will return a supertype of A
    def head: A = ???
    def tail: MyCovList[A] = ???
  }

}
