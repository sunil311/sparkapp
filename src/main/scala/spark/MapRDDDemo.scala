package spark

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object MapRDDDemo {
  def main(args: Array[String]) {

    val logFile = "/home/impadmin/workspace/sparkapp/sunil.csv"

    val conf = new SparkConf().setAppName("get content length Application").setMaster("local");
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile)
    val result = logData.map(name => name.split(","))
    result.foreach { x => println(x.mkString) }
  }
}