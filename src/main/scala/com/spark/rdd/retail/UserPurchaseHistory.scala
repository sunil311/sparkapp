package com.spark.rdd.retail

import com.typesafe.config.ConfigFactory
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object UserPurchaseHistory {
  def main(args: Array[String]) {

    val appConf = ConfigFactory.load()
    val conf = new SparkConf().setAppName("UserPurchaseHistory").setMaster(appConf.getString("deploymentMaster"))

    val sc = new SparkContext(conf)
    
    // we take the raw data in CSV format and convert it into a set of records of the form (user, product, price)
    val data = sc.textFile("UserPurchaseHistory.csv")
      .map(line => line.split(","))
      .map(purchaseRecord => (purchaseRecord(0), purchaseRecord(1), purchaseRecord(2)))
    
    // let's count the number of purchases
    val numPurchases = data.count()
    println(numPurchases)
    
    // let's count how many unique users made purchases
    val uniqueUsers = data.map { case (user, product, price) => user }.distinct().count()
    println(uniqueUsers)

    // let's sum up our total revenue
    val totalRevenue = data.map { case (user, product, price) => price.toDouble }.sum()
    println(totalRevenue)
    
    // let's find our most popular product
    val productsByPopularity = data
      .map { case (user, product, price) => (product, 1) }
      .reduceByKey(_ + _)
      .collect()
      .sortBy(-_._2)
    println(productsByPopularity)  
    val mostPopular = productsByPopularity(0)
    println(mostPopular)  
  }
}