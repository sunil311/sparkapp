import java.io._

class PointTrait(val xc: Int, val yc: Int) {
   var x: Int = xc
   var y: Int = yc
   
   def move(dx: Int, dy: Int) {
      x = x + dx
      y = y + dy
      println ("Point x location : " + x);
      println ("Point y location : " + y);
   }
}

object Demo {
   def main(args: Array[String]) {
      val pt = new PointTrait(10, 20);

      // Move to a new location
      pt.move(10, 10);
   }
}