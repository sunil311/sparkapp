import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


object SimpleApp {
  def main(args: Array[String]) {
    val logFile = "/home/impadmin/abcd.txt" // Should be some file on your system
    
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local");
    val sc = new SparkContext(conf)
    
    //val sc = new SparkContext(args(0), "simple example")
    
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    sc.stop()
  }
}