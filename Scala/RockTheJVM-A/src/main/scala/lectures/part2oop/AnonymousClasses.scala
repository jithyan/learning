package lectures.part2oop

object AnonymousClasses extends App{
  abstract class Animal {
    def eat: Unit
  }

  trait Animal2 {
    def eat: Unit
  }

  //Anonymous classes !
  val funnyAnimal = new Animal{
    override def eat: Unit = println("HAHAHAHAHAHAH")
  }
  val funnyAnimal2 = new Animal2 {
    override def eat: Unit = println("ahahahhaahah")
  }

  println(funnyAnimal.getClass)
  println(funnyAnimal2.getClass)

  // What the compiler actually does:
  /**
    * class AnonymousClasses$$anon$1 extends Animal {... }
    * class AnonymousClasses$$anon$2 with Animal2 {...}
    */

  //// Example 2
  class Person(name: String) {
    def sayHi = s"Hi my name is $name"
  }
  val jim:Person = new Person("Jim") {
    override def sayHi = s"Hello I am Jim. Please don't hit me."
  }


  /*
  Exercises:
  1. Generic trait MyPredicate[-T]
  2. Generic trait MyTransformer[-A, B] - Converts A to B
  3. On MyList:
    - map(transformer) => MyList
    - filter(predicate) => MyList
    - flatMap(transfromer from A to MyList[B]) => MyList[B]

    class EvenPredicate extends MyPredicate[Int]
    class StringToIntTransformer extends MyTransformerp[String, Int]

    [1,2,3].map(n*2) = [2, 4, 6]
    [1,2,3,4].filter(m % 2) = [2,4]
    [1,2,3].flatMap(n => [n, n+1]) => {1,2,2,3,3,4]

     */

}
