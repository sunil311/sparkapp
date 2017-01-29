package ggsi.clsobj.inheritence

class Student(val m1: Int, val m2: Int) {
  var total: Int = m1 + m2
  var ma1: Int = m1
  var ma2: Int = m2
  def calculateTotal(ma1: Int, ma2: Int) {
    total = ma1 + ma2
    println("Total is :" + total)
  }
  override def toString(): String = "(" + total + ")";
}

class CollegeStudent(override val m1: Int, override val m2: Int, val m3: Int, val m4: Int) extends Student(m1, m2) {
  var ma3: Int = m3
  var ma4: Int = m4
  var tot: Int = 0;
  def calculateTotal(ma1: Int, ma2: Int, ma3: Int, ma4: Int) {
    tot = ma1 + ma2 + ma3 + ma4
    println("Total is :" + tot)
  }
  override def toString(): String = "(" + tot + ")";
}

object ColStud {
  def main(args: Array[String]) {
    val total = new CollegeStudent(72, 65, 85, 60);
    total.calculateTotal(72, 65, 85, 60);
    println("Grand Total Marks of the Student is" + total)
  }
}