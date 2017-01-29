package ggsi.serialization

import java.io._

object MyDeserialize extends App {
  val fis = new FileInputStream("/tmp/personanimal.csv")
  val ois = new ObjectInputStream(fis)

  val animal = ois.readObject
  val person = ois.readObject
  ois.close
  println(animal)
  println(person)
}