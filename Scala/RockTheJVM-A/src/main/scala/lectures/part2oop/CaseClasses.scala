package lectures.part2oop

object CaseClasses extends App {
  // Often for lightweight data structures, we need to reimplement all kinds of boiler plate.
  // e.g. equals, hashCode, toString
  // Case classes are a solution to this problem - a short hand for creating lightweight data classes

  case class Person(name: String, age: Int)

  // 1. Class Parameters are promoted to fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  //2. Sensible toString representation - not a cryptic hash code
  println(jim) //this is equal to println(jim.toString)

  //3. equals and hashCode implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  //4. Have handy copy methods
  val jim3 = jim.copy(age = 45)
  val jim4 = jim3.copy()

  //5. Have companion objects - compiler automatically creates a companion Scala Object for a case class
  val thePerson = Person
  val mary = Person("Mary", 23) //Uses the apply method - so we don't need the keyword new!

  //6. Case Classes are serializable!
  // Useful for Akka framework

  //7. Case Classes have extractor patterns - i.e. they can be used in PATTERN MATCHING


  case object UnitedKingdom {
    def name: String = "The UK"
  }
  // Same as CCs but they don't have Case Classes


}
