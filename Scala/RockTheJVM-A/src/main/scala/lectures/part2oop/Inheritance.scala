package lectures.part2oop

object Inheritance extends App {

  //super class
  sealed class Animal {
    val creatureType = "wild"
    def eat = println("nomnomnom")
    protected def drink = println("glug glug glug")
  }

  //subclass
  // Scala offers only offers single inheritance only
  // Only non-private members are inherited
  class Cat extends Animal {
    def sip = drink
  }

  val cat = new Cat
  cat.eat
  //cat.drink does not work
  cat.sip


  //Constructors
  // act in a particular way when dealing with inheritance

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  //class Adult(name: String, age: Int, idCard: String) extends Person - Does not compile!
  // Why? Because when calling the constructor of subclass, the JVM requires
  // the the constructor of the super class to be called.

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)
  class Adult2(name: String, age: Int, idCard: String) extends Person(name)

  class Dog extends Animal {
    override val creatureType: String = "domestic"
    override def eat: Unit = println("crunch crunch crunch")

    def quenchThirst: Unit = super.drink
  }

  val dog: Animal = new Dog
  println(dog.creatureType)
  println(dog.eat)

  val dog2: Dog = new Dog

  //super
  dog2.quenchThirst

  // Preventing overrides
  // 1. Use the keyword final on member
  // 2. Use final on the class itself - prevents the entire class from being extending
  // 3. Seal the class (sealed) = softer restriction - you can extend within this file, but not in another file
}
