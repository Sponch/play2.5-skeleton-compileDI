name := """play-skeleton"""

version := "0.0.1-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.11"

val enumeratumVersion = "1.5.11"
libraryDependencies ++= Seq(
//  jdbc,
//  cache,
//  ws,
  "org.typelevel" %% "cats" % "0.9.0",
  "com.beachape" %% "enumeratum" % enumeratumVersion,
  "com.beachape" %% "enumeratum-play-json" % enumeratumVersion,
  "play-circe" %% "play-circe" % "2.5-0.7.0",
  "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test
)

val circeVersion = "0.8.0"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-generic-extras",
  "io.circe" %% "circe-parser",
  "io.circe" %% "circe-optics",
  "io.circe" %% "circe-java8"
).map(_ % circeVersion)
