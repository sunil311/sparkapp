package com.spark.rdd.anatomy

import org.apache.spark.SparkContext

object RunJobExample {

  def main(args: Array[String]) {

    val sc = new SparkContext(args(0), "run job example")
    val salesData = sc.textFile(args(1))

    println("built in collect " +salesData.collect().toList)
    //implement collect using runJob API

    val results = sc.runJob(salesData, (iter: Iterator[String]) => iter.toArray)
    val collectedResult = Array.concat(results: _*).toList
    println("result of custom collect " +collectedResult)


  }

}
