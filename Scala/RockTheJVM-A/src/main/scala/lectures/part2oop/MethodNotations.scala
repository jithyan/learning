package lectures.part2oop

object MethodNotations extends App{
 class Person(val name: String, val favouriteMovie: String, val age: Int = 18) {
   def likes(movie: String): Boolean = movie == favouriteMovie
   def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
   def unary_! : String = s"$name, what the heck!" ///NOTE THE SPACE BETWEEN ! and : - otherwise compiler thinks : is part of !
   def isAlive: Boolean = true
   //The method name and signature is very important
   def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"

   //Exercises
   def +(nickname: String): Person = new Person(this.name + s" ($nickname)", this.favouriteMovie, 20)
   def unary_+ : Person = new Person(this.name, this.favouriteMovie, this.age + 1)
   def learns(skill: String): String = s"$name learns $skill."
   def learnsScala(): String = this learns "Scala"
   def apply(n: Int) = s"$name watched $favouriteMovie $n times"

 }
  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))

  println(mary likes "Inception")
  //INFIX notation or operator notation - works only with methods with one parameter!

  //"operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)
  // "hangOutWith" is an operator, like in math
  // ALL OPERATORS ARE METHODS IN SCALA
  println(1 + 2)
  println(1.+(2))
  // This means you can name your methods however you want!
  // E.g. Akka - ! and ?

  //PREFIX notation (another form of syntactic sugar
  // All about unary operators. E.g. -1, - is a unary operator
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !
  println(!mary)
  println(mary.unary_!)

  //POSTFIX notation
  // For methods that don't have any parameters
  println(mary.isAlive) //This is used more often, as it is easier to read!
  println(mary isAlive) //POSTFIX notation

  //apply
  println(mary.apply())
  println(mary()) //equivalent
  //Whenever an object is called like a method, it looks for the apply() method
  // Extremely special in Scala and is often used
  // Breaksdown the barrier between oop and functional

  /**
    * Exercises
    * ---------
    * 1. Overload the + operator
    *   mary + "the rockstar" => new person "Mary (the rockstar)"
    *
    * 2. Add an age to the Person class
    *   Add a unary + operator => new person with the age + 1
    *   +mary => mary with an age incrementer
    *
    * 3. Add a "learns" method in the Person class => "Mary learns Scala"
    *   Add a learnsScala method, doesn't have parameters, calls the learns method. Use Postfix notation
    *
    * 4. Overload the apply method
    *  mary.apply(2) => "Mary watched Inception 2 times"
    */
  println((mary + "the rockstar").name)
  println((+mary).age)
  println(mary learns "Math")
  println(mary learnsScala)
  println(mary(2))
}
