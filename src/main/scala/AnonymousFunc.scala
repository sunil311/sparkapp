

object AnonymousFunc {

  def main(args: Array[String]) {
    println(inc(7) - 1)

  }
  var inc = (x: Int) => x + 1

  // var x = inc(7)-1
}