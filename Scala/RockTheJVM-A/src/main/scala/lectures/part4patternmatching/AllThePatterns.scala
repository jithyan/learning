package lectures.part4patternmatching

import exercises.{FCons, FEmpty, FList}

object AllThePatterns extends App {

  // 1. Constants
  val x: Any = "Scala"

  val constants = x match {
    case 1 => "a number"
    case "Scala" => "THE Scala"
    case true => "The Truth"
    case AllThePatterns => "A singleton object"
  }

  // 2. Match anything
  //2.1 Wildcard
  val matchAnything = x match {
    case _ =>"dummy"
  }

  //2.2 variable
  val matchVariable = x match {
    case something => s"I've found $something" //something could be anything!
  }

  // 3. Tuples
  val aTuple = (2,3)
  val matchTuple = aTuple match {
    case (1, 1) =>"dummy"
    case (something, 2) =>"dummy"
  }

  val nestedTuple = (1, (2, 3))
  val matchNestedTuple = nestedTuple match {
    case (_, (2, v)) =>"dummy"
  }
  //PMs can be nested!

  // 4. Case Classes - Constructor
  // can be nested with case classes as well
  val aList: FList[Int] = FCons(1, FCons(2, FEmpty))
  val matchList = aList match {
    case FEmpty =>"dummy"
    case FCons(head, tail) =>"dummy"
    case FCons(head, FCons(subhead, subtail)) =>"dummy"
  }

  // 5 - List Patterns
  val aStandardList = List(1,2,3,42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => "dummy"//extractor - even though not a case class (advanced topic!)
    case List(1, _*) => "dummy"//list of arbitrary length - advanced!
    case 1 :: List(_) => "dummy"//infix pattern
    case List(1,2,3) :+ 42 => "dummy"// infix pattern
  }

  //6 - Type Specifiers
  val unknown: Any  = 2
  val unknownMatch = unknown match {
    case list: List[Int] => "dummy"//explicit type specifier
    case _ =>
  }

  // 7. Name Binding
  // name binding allows you to name patterns
  val nameBinding = aList match {
    case nonEmptyList @ FCons(_,_) =>"dummy" //name binding => use the name later (here)
    case FCons(1, rest @ FCons(2, _)) => "dummy"//name binding in nested patterns
  }

  // 8. Multi-Patterns
  val multiPattern = aList match {
    case FEmpty | FCons(0, _) => "dummy"//compound pattern
  }

  // 9. If guards
  val secondElementSpecial = aList match {
    case FCons(_, FCons(specialElement, _)) if (specialElement % 2 == 0) => "dummy"
  }

  // SPECIAL NOTE
  // The thing you need to know about the JVM...
  val numbers = List(1,2,3)
  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "list of strings"
    case listOfInts: List[Int] => "list of ints"
    case _ => "Don't care about this."
  }
  "dummy"
  println(numbersMatch)
  /**
    * The above will print "list of strings" !!!
    * Why?
    * Short story - JVM's design!
    * Long story -
    *  To ensure backwards compatibility with JVM 1.
    *  JVM before 5 had no idea about Generics.
    *  So after compile time safety check of Generics, the compiler erases
    *  the generic types - all the JVM sees is List!
    *
    *  This is called "Type Erasure"
    *  The IDE actually warns you about this!
    */
}
