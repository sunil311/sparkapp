package ggsi.serialization

import java.io.ObjectOutputStream
import java.io.FileOutputStream
import java.io.FileInputStream
import java.io.ObjectInputStream

class Person(val age: Int) extends Serializable {
  override def toString = s"Person($age)"
}
object PersonObj {
  def main(args: Array[String]) {
    val os = new ObjectOutputStream(new FileOutputStream("/tmp/example.csv"))
    os.writeObject(new Person(22))
    os.close()

    val is = new ObjectInputStream(new FileInputStream("/tmp/example.csv"))
    val obj = is.readObject()
    is.close()
    println(obj)
  }
}