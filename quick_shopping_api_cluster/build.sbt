name := "quick_shopping_api_cluster"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)     

play.Project.playJavaSettings

libraryDependencies ++= Seq(
  "com.googlecode.json-simple" % "json-simple" % "1.1.1",
  "com.google.guava" % "guava" % "18.0",
  "com.google.protobuf" % "protobuf-java" % "2.6.1",
  "com.google.inject" % "guice" % "3.0"
  )

libraryDependencies += "com.google.code.gson" % "gson" % "2.3.1"