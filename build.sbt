import sbt._
import sbt.Keys._

def build(pjName: String, base: String) = Project(
    id = pjName,
    base = file(base),
    settings =
      Seq(
        scalaVersion := "2.11.8",
        name := pjName,
        organization := "com.github.wheaties",
        scalacOptions := Seq(
          "-deprecation",
          "-encoding", "UTF-8",
          "-feature",
          "-language:higherKinds",
          "-language:existentials",
          "-unchecked"
        ),
        publishArtifact in Test := false,
        libraryDependencies ++= Seq(
          "org.scalatest" %% "scalatest" % "3.0.0" % "test"
        ),
        resolvers ++= Seq(
          Resolver.sonatypeRepo("releases"),
          Resolver.sonatypeRepo("snapshots")
        )
      )
  )

lazy val root = (project in file(".")).settings(
  publishArtifact := false
)
.aggregate(presentation, exercise1, exercise2)

lazy val presentation = build("presentation", "presentation")
  .settings{
    libraryDependencies ++= Seq(
      compilerPlugin("com.github.wheaties" %% "twotails" % "0.3.0"),
      "com.github.wheaties" %% "twotails-annotations" % "0.3.0"
    )
  }

lazy val exercise1 = build("exercise1", "exercise1")

lazy val exercise2 = build("exercise2", "exercise2")