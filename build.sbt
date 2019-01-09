name := "scala-worksheets"

version := "0.1"

scalaVersion := "2.12.8"


libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"
scalacOptions += "-Ypartial-unification"