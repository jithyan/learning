package lectures.part2oop

object OOBasics extends App {
  val person = new Person
  println(person)

  val p2 = new Person2("John", 26)
  //p2.age -- DOES NOT WORK - because we defined class parameters, not fields!

  val p3 = new Person3("Jason", 30)
  println(p3.age)

  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)
  println(novel authorAge)
  println(novel isWrittenBy author)
  val c = new Counter(5)
  println(c.currentCount)
  val c2 = c ++
  val c3 = c2 ++ 5
  println(c2.currentCount)
  println(c3.currentCount)

  class Person
  class Person2(name: String, age: Int) // Class with constructor - a class parameter to be precise.

  //Class fields: simply add val!
  class Person3(name: String, val age: Int)

  class Person4(name: String, val age: Int) {
    //body
    val x = 2 //Also a filed

    println(1 + 3) // Expressions are evaluated in a class body!

    def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
    def greet(): Unit = println(s"Hi, I am $name") //${this.name} is implied

    //multiple constructors
    def this(name: String) = this(name, 0)
    def this() = this("John Doe")
    // These aren't overloaded constructors - rather auxiliary constructors, as an aux constructor
    // can only call another constructor! making them rather useless.
    // It's easier to simply provide a default value to the primary constructor.
  }

  /**
    * EXERCISES
    * 1)
    * Writer: first name, surname, year]
    *   -method fullname
    * Novel: name, year of release, author
    *  methods:
    *  - authorAge
    *  - isWrittenBy(author)
    *  - copy(new year of release) = new instance of  Novel
    *
    * 2)
    * Counter class:
    *   - receives an int value
    *   - method current count
    *   - method to increment/decrement => new Counter
    *   - overload inc/dec to receive an amount
    */

  class Writer(firstName: String, surname: String, val yearOfBirth: Int) {
    val fullName = s"$firstName $surname"
  }

  class Novel(val name: String, val yearOfRelease: Int, val author: Writer) {
    def authorAge:Int = yearOfRelease - author.yearOfBirth

    def isWrittenBy(author: Writer):Boolean = author == this.author

    def copy(yearOfRelease: Int) = new Novel(name, yearOfRelease, author)
  }

  class Counter(val currentCount: Int) {
    def increment() = new Counter(currentCount + 1)
    def ++ =  new Counter(currentCount + 1)
    def ++(amount:Int) = new Counter(currentCount + amount)
    def increment(amount: Int) = new Counter(currentCount + amount)
    def decrement() = new Counter(currentCount - 1)
    def decrement(amount: Int) = new Counter(currentCount - amount)
  }

}

