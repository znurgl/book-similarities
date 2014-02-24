name := "book-similarities-scalding"

version := "1.0"

scalaVersion := "2.10.3"

resolvers ++= Seq( "maven.org" at "http://repo2.maven.org/maven2",
                   "conjars.org" at "http://conjars.org/repo",
                   "codahale.com" at "http://repo.codahale.com" )

libraryDependencies += "org.apache.hadoop" % "hadoop-common" % "2.2.0"

libraryDependencies += "com.twitter" % "scalding-core_2.10" % "0.8.11"

libraryDependencies += "log4j" % "log4j" % "1.2.7"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0"