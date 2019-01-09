case class Person(name: String, age: Int)
case class AgeNegativeException(message: String) extends Exception(message)

def createPerson(desc: String): Person = {
  val split = desc.split(" ")
  val age= split(1).toInt
  if(age<0)
    throw AgeNegativeException(s"age: $age should be > 0")
  else
    Person(split(0),age)
}


createPerson("John 25")
//createPerson("John25")
//createPerson("John -24")
//createPerson("John 25.3")

def averageAge(desc: Vector[String]): Double= {
  val total = desc.map(createPerson).map(_.age).sum
  total / desc.length
}

import scala.util.control.NonFatal
def personsSummary(personInput: String): String = {
  val descs = personInput.split("\n").toVector
  val avg = try{
    averageAge(descs)
  } catch {
    case e: AgeNegativeException =>
      print(s"one of the persons has a negative age: $e")
      0
    case NonFatal(e) =>
      print(s"something was wrong in the input: $e")
      0
  }
  s"${descs.length} persons with an average age of $avg"
}


personsSummary("John 25\nSharleen 45")
//personsSummary("John 25\nSharleen45")


import java.net.URL
import scala.annotation.tailrec
import java.io.IOException
val stream = new URL("https://lambda-technology.co.uk/").openStream()
val htmlPage: String =
  try{
    @tailrec
    def loop(builder: StringBuilder): String = {
      val i = stream.read()
      if(i != -1)
        loop(builder.append(i.toChar))
      else
        builder.toString()
    }
    loop(StringBuilder.newBuilder)
  } catch {
    case e: IOException => s"cannot read URL: $e"
  } finally {
    stream.close()
  }

val htmlPage2 = scala.io.Source.fromURL("https://lambda-technology.co.uk/").mkString