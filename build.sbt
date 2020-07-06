import Dependencies._
import ScalacOptions._

val projectName        = "playground-magnolia"
val projectDescription = "My playground for propensive/magnolia"
val projectVersion     = "0.1.0"

val scala212               = "2.12.11"
val scala213               = "2.13.3"
val supportedScalaVersions = List(scala213, scala212)

inThisBuild(
  Seq(
    version := projectVersion,
    scalaVersion := scala213,
    crossScalaVersions := supportedScalaVersions,
    publish / skip := true,
    libraryDependencies ++= Seq(
      catsCore,
      magnolia,
      silencerLib,
      silencerPlugin,
      kindProjectorPlugin,
      betterMonadicForPlugin
    )
  )
)

lazy val root = (project in file("."))
  .aggregate(playground)
  .settings(
    name := projectName,
    description := projectDescription,
    crossScalaVersions := Seq.empty
  )

lazy val playground = (project in file("playground"))
  .dependsOn(util)
  .settings(
    name := "playground",
    description := "My playground to play with Magnolia and Contextual (magnolia + contextual use site)",
    scalacOptions ++= scalacOptionsFor(scalaVersion.value),
    // suppress unused import warnings in the scala repl
    console / scalacOptions := removeScalacOptionXlintUnusedForConsoleFrom(scalacOptions.value)
  )

lazy val util = (project in file("util"))
  .enablePlugins(BuildInfoPlugin)
  .settings(
    name := "util",
    description := "Utilities",
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "build",
    scalacOptions ++= scalacOptionsFor(scalaVersion.value)
  )
