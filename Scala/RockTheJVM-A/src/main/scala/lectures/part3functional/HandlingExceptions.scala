package lectures.part3functional

import scala.util.{Failure, Random, Success, Try}

object HandlingExceptions extends App {
  /**
    * The problem with traditional try-catch blocks is that it makes code hard to follow.
    * So how do we avoid them?
    *
    * A "Try" is a wrapper for a computation that might fail or not:
    * sealed abstract class Try[+T]
    * case class Failure{+T](t: Throwable) extends Try[T] -- wrap failed computations
    * case class Success[+T](value: T) extends Try[T] -- wrap succeeded computations
    */

  //create success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("Im a failure"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("NO STRING FOR YOU BUSTER")

  // Create Try objects via apply
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  //syntax sugar
  val anotherPotentialFailure = Try {
    //code that might throw
  }

  //utilities
  println(potentialFailure.isSuccess) //isFailure is also present

  // orElse
  def backupMethod(): String = "A valid result"
  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))

  // If you design an API that throws Exceptions
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException(":("))
  def betterBackupMethod(): Try[String] = Success("A valid result")
  val betterFallback = betterUnsafeMethod() orElse betterBackupMethod()

  //also has map, flatMap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10)) // Will turn into a failure!
  // so can use for comprehensions !

  /*
  Exercise
   */
  //Given these details:
  //-------------------------------
  val hostname = "localhost"
  val port = "8080"

  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val rand = new Random(System.nanoTime())

      if (rand.nextBoolean()) "<html>..</html>"
      else throw new RuntimeException("Connection interrupted")
    }

    //sol
    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val rand = new Random(System.nanoTime())

    def getConnection(host:String, port: String): Connection = {
      if (rand.nextBoolean())
        new Connection
      else
        throw new RuntimeException("Port is already in use!")
    }

    //sol
    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }
  //----------------------------------------------------------

  //if you get the html page from the connection, print it to the console
  // call renderHTML

  // -- my attempt
  Try(HttpService.getConnection(hostname, port)).map(_.get("url")).foreach(renderHTML)

  // solution
  val possibleConnection = HttpService.getSafeConnection(hostname, port)
  val possibleHTML = possibleConnection.flatMap(conn => conn.getSafe("url"))
  possibleHTML.foreach(renderHTML)

  //short hand
  HttpService.getSafeConnection(hostname, port).flatMap(conn => conn.getSafe("url")).foreach(renderHTML)

  //for comprehension
  for {
    conn <- HttpService.getSafeConnection(hostname, port)
    html <- conn.getSafe("url")
  } renderHTML(html)
}
