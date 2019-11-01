package lectures.part2oop

object Objects extends App {
  //Objects in Scala are a dedicated concept

  //SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY (I.E. STATIC)
  // Instead it has Object, which is "static" like functionality

  object Person { //Objects do not receive parameters
    val N_EYES = 2
    def canFly: Boolean = false

    //factory method - sole responsibility is to build a person given some parameters
    def from(mother: Person, father: Person): Person = new Person("Bob")
    def apply(mother: Person, father: Person): Person = new Person("Bob-Applied")
    // The "apply" method is actually what's used as a factory in Scala!
  }

  class Person(val name: String) {
    // instance-level functionality
  }
  //COMPANIONS
  // Scala companions can access each other's private members!

  println(Person.N_EYES)

  // Scala object is a SINGLETON instance
  // Singleton is implemented in one line!
  val mary = Person
  val john = Person
  println(mary == john)  // They point to the same instance

  val joseph = new Person("Joseph")
  val judith = new Person("Judith")
  println(joseph != judith)

  val bobbie = Person.from(judith, joseph)
  val aBob = Person(judith, joseph) //using apply method, as is the convention

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit -- Has to be the same as Java since it runs on the jvm
  // A shorter way is to just extend App -- already has a main method
}
