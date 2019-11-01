package lectures.part3functional

object TuplesAndMaps extends App {
  //tuples = finite, ordered "lists"
  val tuple1: Tuple2[Int, String] = new Tuple2[Int, String](2, "Hello, scala")
  val tuple2 = Tuple2(2, "Hello Scala")
  val tuple3 = (2, "Hello, Scala")
  //Can group up to 22 elements

  println(tuple1._1) // 2
  println(tuple1._2) //Hello Scala
  println(tuple1.copy(_2 = "goodbye Java"))
  println(tuple1.swap) // ("hello, Scala", 2)

  // Maps: keys -> values
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Jim", 555), ("Daniel", 789))
  val anotherPhoneBook = Map("Jim" -> 555, "Daniel" -> 789)
  println(phoneBook)

    // Map Ops
  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim")) //If key doesn't exist will crash

  val phoneBook2 = phoneBook.withDefaultValue(-1)
  println(phoneBook2("Mary")) //wont crash since it has a default

  //Add a pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = phoneBook2 + newPairing
  println(newPhoneBook)

  //functionals on maps
  // map, flatMap, filter
  println(phoneBook2.map(pair => pair._1.toLowerCase -> pair._2)) //converts key to lowercase

  // filterKeys
  println(phoneBook2.filterKeys(_.startsWith("J")))

  //mapValues
  println(phoneBook2.mapValues(number => number * 10))

  //conversions to other collections
  println(phoneBook2.toList)
  println( List(("Daniel", 999)).toMap )

  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println( names.groupBy(name => name.charAt(0)) )
}
