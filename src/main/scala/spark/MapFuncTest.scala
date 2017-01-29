package spark

import org.apache.spark.SparkContext

object MapFuncTest {
  def main(args: Array[String]) {

    val sc = new SparkContext(args(0), "map func test")
    val dataRDD = sc.textFile(args(1))
    val result = dataRDD.map( name => (name.charAt(0),name))
    .groupByKey()
    .mapValues(names => names.toSet.size)
    .collect()
    println(result.mkString)
  }
}