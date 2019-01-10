val opt0: Option[Int] = None

val opt1: Option[Int] = Some(1)

val list0 = List.empty[String]
list0.headOption
list0.lastOption


val list1 = List("Hello","World")
list1.headOption
list1.lastOption


def personDesc(name: String, db: Map[String, Int]): String =
  db.get(name) match {
    case Some(age) => s"$name is $age years old"
    case None => s"$name is not present in db"
  }

val db = Map("John" -> 25, "Rob" -> 40)
personDesc("John", db)
personDesc("Mischak", db)


def personDesc2(name: String, db: Map[String, Int]): String = {
  val optString: Option[String] = db.get(name).map(age => s"$name is $age years old")
  optString.getOrElse(s"$name is not present in db")
}

personDesc2("John", db)