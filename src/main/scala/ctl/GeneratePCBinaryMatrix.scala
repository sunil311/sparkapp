package ctl

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.IntegerType
import breeze.linalg.{DenseMatrix, DenseVector}

object GeneratePCBinaryMatrix extends App {
  val spark = SparkSession.builder
    .master("local")
    .appName("getting required info from rating data")
    .getOrCreate()

  val ratingData = spark.read.option("header", "true").csv(args(0))
  ratingData.printSchema()
  //comCustMode.createTempView("cumcustmode")
  //ratingData.agg(max("CUSTOMER_ID") as "CUSTOMER_ID").show()
  
  val changeCustDataType = ratingData.withColumn("CUSTOMER_ID", ratingData.col("CUSTOMER_ID").cast(IntegerType))
  val maxCustNumber = changeCustDataType.agg(max("CUSTOMER_ID") as "CUSTOMER_ID").show()
  
  val changeProdDataType = ratingData.withColumn("PRODUCT_ID", ratingData.col("PRODUCT_ID").cast(IntegerType))
  val maxProdNumber = changeProdDataType.agg(max("PRODUCT_ID") as "PRODUCT_ID").show()
  val denseMatrix = DenseMatrix.eye[Double](5)
  println(denseMatrix)
}