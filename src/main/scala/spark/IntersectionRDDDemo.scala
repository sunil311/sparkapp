package spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object IntersectionRDDDemo {
  def main(args: Array[String]) {

    val logFile = "/home/impadmin/workspace/sparkapp/sunil.csv"
    val logFile1 = "/home/impadmin/workspace/sparkapp/gupta.csv"

    val conf = new SparkConf().setAppName("get content length Application").setMaster("local");
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile)
    val logAnotherData = sc.textFile(logFile1)
    val result = logData.intersection(logAnotherData)
    result.foreach { x => println(x.mkString) }
  }
}