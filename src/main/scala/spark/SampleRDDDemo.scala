package spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object SampleRDDDemo {
  def main(args: Array[String]) {

    val logFile = "/home/impadmin/workspace/sparkapp/sunil.csv"

    val conf = new SparkConf().setAppName("get content length Application").setMaster("local");
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile)
    val result = logData.sample(false, 0.5)
    result.foreach { x => println(x.mkString) }
  }
}