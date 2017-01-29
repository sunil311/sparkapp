package ggsi.serialization

import java.io.FileOutputStream
import java.io.ObjectOutputStream

@SerialVersionUID(15L)
class Animal(name: String, age: Int) extends Serializable {
  override def toString = s"Animal($name, $age)"
}

case class Person1(name: String) extends Serializable

object MySerialize extends App {
  val fos = new FileOutputStream("/tmp/personanimal.csv")
  val oos = new ObjectOutputStream(fos)

  oos.writeObject(new Animal("Lion", 12))
  oos.writeObject(Person1("Sunil"))
  oos.close
}