addSbtPlugin("org.foundweekends.giter8" %% "sbt-giter8"   % "0.13.1")
addSbtPlugin("org.scalameta"             % "sbt-scalafmt" % "2.4.6")

libraryDependencies ++=
  Seq(
    "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value,
  )
