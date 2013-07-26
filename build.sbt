scalaVersion := "2.10.2"

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "OSS Sonatype" at "https://oss.sonatype.org/content/groups/public/"
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.2.0",
  "com.typesafe.akka" %% "akka-testkit" % "2.2.0" % "test",
  "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"
)

scalacOptions ++= Seq("-feature", "-language:postfixOps")
