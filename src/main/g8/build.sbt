organization := "com.example"

name := "$name$"

val unusedWarnings = (
  "-Ywarn-unused" ::
  Nil
)

scalacOptions ++= PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion.value)){
  case Some((2, v)) if v >= 11 => unusedWarnings
}.toList.flatten

Seq(Compile, Test).flatMap(c =>
  scalacOptions in (c, console) --= unusedWarnings
)

scalacOptions ++= "-deprecation" :: "unchecked" :: "-feature" :: Nil

version := "$version$"

scalaVersion := "$scala_version$"

val unfilteredVersion = "$unfiltered_version$"

libraryDependencies ++= Seq(
   "ws.unfiltered" %% "unfiltered-netty-server" % unfilteredVersion,
   "ws.unfiltered" %% "unfiltered-specs2" % unfilteredVersion % "test"
)
