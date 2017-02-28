name := "sparkapp"

version := "1.0"

libraryDependencies += "commons-logging" % "commons-logging" % "1.2"
libraryDependencies += "org.springframework" % "spring-core" % "4.3.3.RELEASE"
libraryDependencies += "org.springframework" % "spring-beans" % "4.3.3.RELEASE"
libraryDependencies += "org.springframework" % "spring-context" % "4.3.3.RELEASE"
libraryDependencies += "org.springframework" % "spring-context-support" % "4.3.3.RELEASE"
libraryDependencies += "org.apache.spark" % "spark-core_2.10" % "2.1.0"
libraryDependencies += "org.apache.spark" % "spark-sql_2.10" % "2.1.0"
libraryDependencies += "org.apache.spark" % "spark-mllib_2.10" % "2.1.0"
libraryDependencies += "org.apache.spark" % "spark-streaming_2.10" % "2.1.0"
libraryDependencies += "com.typesafe" % "config" % "1.3.1"
