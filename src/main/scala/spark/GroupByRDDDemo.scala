package spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object GroupByRDDDemo {
  def main(args: Array[String]) {

    val logFile = "/home/impadmin/workspace/sparkapp/sunil.csv"
    val conf = new SparkConf().setAppName("get content length Application").setMaster(args(0));
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile)
    val result = logData.map(x => x.split(",")).map(name => (name(1), name(0))).groupByKey().mapValues { x => x }.foreach(x => println(x))
    //val result = logData.map(x => x.split(",")).map(name => (name(1), name(0))).groupByKey().collect()
    //println(result.mkString)
  }
}
