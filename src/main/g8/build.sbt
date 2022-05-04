import Dependencies._

// give the user a nice default project!
ThisBuild / organization := "$organisation$"
ThisBuild / version := "$version$"

lazy val root = (project in file("."))
  .enablePlugins(JavaAppPackaging)
  .settings(BuildHelper.stdSettings)
  .settings(
    name := "$name$",
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework"),
    libraryDependencies ++= Seq(`zio-test`, `zio-test-sbt`, `zio-http`, `zio-http-test`),
  )
  .settings(
    Docker / version          := version.value,
    Compile / run / mainClass := Option("$package$.$name;format="word,cap"$"),
  )

addCommandAlias("fmt", "scalafmt; Test / scalafmt; sFix;")
addCommandAlias("fmtCheck", "scalafmtCheck; Test / scalafmtCheck; sFixCheck")
addCommandAlias("sFix", "scalafix OrganizeImports; Test / scalafix OrganizeImports")
addCommandAlias("sFixCheck", "scalafix --check OrganizeImports; Test / scalafix --check OrganizeImports")
