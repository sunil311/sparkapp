package RDD

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object LengthOfContent {
  def main(args: Array[String]) {
    val logFile = "/home/impadmin/abcd.csv"

    val conf = new SparkConf().setAppName("get content length Application").setMaster("local");
    val sc = new SparkContext(conf)

    val logData = sc.textFile(logFile)
    val length = logData.map(line => line.length())
    val numBs = length.reduce((a,b)=>a+b)
    println("length of content :"+numBs)
    sc.stop()
  }
}