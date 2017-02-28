package com.spark.rdd.retail

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.hadoop.fs._
import java.net.URI
import com.typesafe.config.ConfigFactory

object AvgRevenueDaily {
  def main(args: Array[String]) {
    val appConf = ConfigFactory.load()
    val conf = new SparkConf().setAppName("Average Revenue - Daily").setMaster(appConf.getString("deploymentMaster"))
    val sc = new SparkContext(conf)
    val inputPath = args(0)

    val fs = FileSystem.get(new URI(inputPath), sc.hadoopConfiguration)

    val inputPathExists = fs.exists(new Path(inputPath))

    if (!inputPathExists) {
      println("Input Path does not exists")
      return
    }
    val ordersRDD = sc.textFile(inputPath + "/orders")
    val orderItemsRDD = sc.textFile(inputPath + "/order_items")

    val ordersCompleted = ordersRDD.
      filter(rec => (rec.split(",")(3) == "COMPLETE"))

    val orders = ordersCompleted.
      map(rec => (rec.split(",")(0).toInt, rec.split(",")(1)))
    val orderItemsMap = orderItemsRDD.
      map(rec => (rec.split(",")(1).toInt, rec.split(",")(4).toFloat))

    val orderItems = orderItemsMap.
      reduceByKey((acc, value) => acc + value)

    val ordersJoin = orders.join(orderItems)

    val ordersJoinMap = ordersJoin.map(rec => (rec._2._1, rec._2._2))

    val revenuePerDay = ordersJoinMap.aggregateByKey((0.0, 0))(
      (acc, value) => (acc._1 + value, acc._2 + 1),
      (total1, total2) => (total1._1 + total2._1, total1._2 + total2._2))

    val averageRevenuePerDay = revenuePerDay.
      map(rec => (rec._1, BigDecimal(rec._2._1 / rec._2._2).
        setScale(2, BigDecimal.RoundingMode.HALF_UP).toFloat))

    val averageRevenuePerDaySorted = averageRevenuePerDay.sortByKey()

    averageRevenuePerDaySorted.map(rec => rec._1 + "," + rec._2).foreach(println)

    println("success")

  }
}