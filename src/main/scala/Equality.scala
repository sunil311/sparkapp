
class Person(val name: String)

//case class Person(val name: String)

/*class Person(val name: String) {
    override def equals(that: Any) : Boolean = {
        that.isInstanceOf[Person]  && (this.hashCode() == that.asInstanceOf [Person].hashCode());
    }
    
    override def hashCode = name.hashCode
}*/

object Equality extends App {
  var person1 = new Person("John")
  var person2 = new Person("John")

  println(person1 == person2)
}