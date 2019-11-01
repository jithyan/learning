package lectures.part3functional

import scala.util.Random

object Options extends App {
  // Tony Hoare - "I call it my billion dollar mistake. It was the invention of the null reference in 1965."

  /**
    * Null references lead to cluttered code checking for nulls.
    *
    * We need a data type that can indicate the possible absence of a value.
    *
    * Option is a wrapper for a value that might be present or not.
    *
    * sealed abstract class Option[+A]
    * case class Some[+A](x: A) extends Option[A]
    * case object None extends Option[Nothing]
    *
    * Some wraps a concrete value
    * None is a singleton for absent values
    */

    val map = Map("key" -> "value")
  map.get("key") // Some("value")
  map.get("Other") //None
  /* Prefer get over using apply because get returns an Option */

  val numbers = List(1,2,3)
  numbers.headOption // Some(1)
  numbers.find(_ % 2 == 0) //Some(2)
  /* lots of functions in collections work with options ! */

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None
  println(myFirstOption)
  println(noOption)

  //unsafe APIs
  def unsafeMethod(): String = null
  val result = Some(unsafeMethod()) //WRONG - NEVER DO THIS! Some needs a valid object.
  val properResult = Option(unsafeMethod()) //Allows you to avoid null checks!
  println(properResult)

  //chained Methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // When DESIGNING unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("Valid result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  // functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) //UNSAFE - DO NOT USE (breaks the whole option idea)

  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter((_ % 2 == 1)))
  println(myFirstOption.flatMap(x => Option(x * 10)))
  // for comprehensions are possible as map, filter, flatMap are implemented

  // Exercise
  // Given the following details:
  val config: Map[String, String] = Map(
    "host" -> "123.45.76.1",
    "port" -> "8781"
  )

  class Connection {
    def connect = "Connected"
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection) else None
  }

  // Try and establish a connection, if so - print the connect method
  val host = config.get("host")
  val port = config.get("port")
  val connection = host.flatMap(h => port.flatMap(p => Connection(h, p)))
  val connectionStatus = connection map (_.connect)
  connectionStatus foreach println

  // -- alternative: chained calls
  config.get("host")
      .flatMap(host => config.get("port")
        .flatMap(port => Connection(host, port)))
    .map(conn => conn.connect)
    .foreach(println)

  // --alternative using for-comprehensions
  val connectionStatus2 = for {
    host <- config.get("host")
    port <- config.get("port")
    conn <- Connection(host, port)
  } yield conn.connect
  connectionStatus2.foreach(println)
}
