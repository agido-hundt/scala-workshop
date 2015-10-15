name := "scala-workshop"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  // ScalaTest
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
  // Akka
  "com.typesafe.akka" %% "akka-actor" % "2.4.0"
)
