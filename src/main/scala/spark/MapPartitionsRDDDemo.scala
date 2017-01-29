package spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import scala.collection.immutable.List
import com.typesafe.config.ConfigFactory

object MapPartitionsRDDDemo {
  def main(args: Array[String]) {

    val logFile = "/home/impadmin/workspace/sparkapp/sunil.csv"
    val appConf = ConfigFactory.load()
    val conf = new SparkConf().setAppName("get content length Application").setMaster(appConf.getString("deploymentMaster"));
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile)
    val result = logData.mapPartitions(x=> List(x).iterator)
    result.foreach { x => println(x.mkString) }
  }
}