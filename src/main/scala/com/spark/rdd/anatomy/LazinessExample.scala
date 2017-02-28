package com.spark.rdd.anatomy

import org.apache.spark.SparkContext

object LazinessExample {

  def main(args: Array[String]) {

    val sc = new SparkContext(args(0),"LazinessExample")

    val dataRDD = sc.textFile(args(1))


    val flatMapRDD = dataRDD.flatMap(value => value.split(""))

    println("type of flatMapRDD is "+ flatMapRDD.getClass.getSimpleName +" and parent is " + flatMapRDD.dependencies.head.rdd.getClass.getSimpleName)

    val hadoopRDD = dataRDD.dependencies.head.rdd

    println("type of  Data RDD is " +dataRDD.getClass.getSimpleName+"  and the parent is "+ hadoopRDD.getClass.getSimpleName)

    println("parent of hadoopRDD is " + hadoopRDD.dependencies)


  }

}
