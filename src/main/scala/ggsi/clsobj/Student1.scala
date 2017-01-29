package ggsi.clsobj

class Student() {
  var total: Int = 0
  def calculateTotal(ma1: Int, ma2: Int) {
    total = ma1 + ma2
  }
  override def toString(): String = "(" + total + ")";
}

object Student1 {
  def main(args: Array[String]) {
    val totalMarks = new Student()
    totalMarks.calculateTotal(55, 60)
    println("Grand Total Marks of the Student is" + totalMarks)
  }
}