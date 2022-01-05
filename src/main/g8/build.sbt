// give the user a nice default project!
ThisBuild / organization := "$organisation$"
ThisBuild / scalaVersion := "$scalaVersion$"
val zhttpVersion = "$zhttpVersion$"

lazy val root = (project in file("."))
  .settings(
    name := "$name$",
    libraryDependencies ++=
      Seq(
        "io.d11" %% "zhttp"      % zhttpVersion
      ),
  )
  .settings(
    fork                      := true,
    Compile / run / mainClass := Option("$package$.$name;format="Camel"$"),
  )

addCommandAlias("fmt", "scalafmt; Test / scalafmt; sFix;")
addCommandAlias("fmtCheck", "scalafmtCheck; Test / scalafmtCheck; sFixCheck")
addCommandAlias("sFix", "scalafix OrganizeImports; Test / scalafix OrganizeImports")
addCommandAlias("sFixCheck", "scalafix --check OrganizeImports; Test / scalafix --check OrganizeImports")
