package spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object MapPartitionsWithIndexRDDDemo {
  def main(args: Array[String]) {

    val logFile = "/home/impadmin/workspace/sparkapp/sunil.csv"

    val conf = new SparkConf().setAppName("get content length Application").setMaster("local");
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile)
    val result = logData.mapPartitionsWithIndex((index: Int,it: Iterator[String]) => it.toList.iterator.map( x => index + ", "+x ))
    result.foreach { x => println(x.mkString) }
  }
}