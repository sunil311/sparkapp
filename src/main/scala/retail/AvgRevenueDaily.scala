package retail

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.hadoop.fs._
import java.net.URI
import com.typesafe.config.ConfigFactory

object AvgRevenueDaily {
  def main(args: Array[String]) {

    val appConf = ConfigFactory.load()
    val conf = new SparkConf().setAppName("Word Count").setMaster(appConf.getString("deploymentMaster"))

    val sc = new SparkContext(conf)

    val inputPath = args(0)
    val outputPath = args(1)

    val fs = FileSystem.get(new URI(inputPath), sc.hadoopConfiguration)

    val inputPathExists = fs.exists(new Path(inputPath))
    val outputPathExists = fs.exists(new Path(outputPath))

    println(inputPath)

    if (!inputPathExists) {
      println("Invalid input path")
      return
    }

    val ordersRDD = sc.textFile(inputPath + "/" + "orders")
    val ordersCompleted = ordersRDD.filter { line => line.split(",")(3).equals("COMPLETE") }
    val orders = ordersCompleted.map(rec => (rec.split(",")(0).toInt, rec.split(",")(1)))

    val orderItemsRDD = sc.textFile(inputPath + "/" + "order_items")
    val orderItemsMap = orderItemsRDD.
      map(rec => (rec.split(",")(1).toInt, rec.split(",")(4).toFloat))

    val orderItems = orderItemsMap.reduceByKey((acc, value) => acc + value)

    val ordersJoin = orders.join(orderItems)
    
    //ordersJoin.map(rec=> println(rec._1 +":"+rec._2._1 +":"+rec._2._2))
    val ordersJoinMap = ordersJoin.map(rec => (rec._2._1, rec._2._2)).foreach(println)
    println("success")
  }
}