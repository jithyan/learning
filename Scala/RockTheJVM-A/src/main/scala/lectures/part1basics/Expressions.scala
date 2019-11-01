package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 //Expression - evaluated to a value
  println(1 == x) // relational operations

  // Instructions -- tell the computer what to do (always done in procedural languages)
  // Expressions -- has a value and or type - every single code has a value (functional languages)
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 // The if expression (not instruction!) returns a value
  println(aConditionedValue)

  var i = 0
  val aWhile = while (i < 10) {
    println(i)
    i += 1
  } // NEVER WRITE THIS AGAIN
  // side effects:  println(), whiles, reassigning

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  } // the scope of z and y is within acodeBlock
  // Code blocks are expressions. Their last line returns a value.
  //Instructions are executed (do something - Java), expressions are evaluated (give me something - Scala)

  //EXPRESSIONS WITH SIDE EFFECTS ARE EXPRESSIONS THAT RETURN TYPE UNIT



}
