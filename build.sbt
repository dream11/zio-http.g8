// This build is for this Giter8 template.
// To test the template run `g8` or `g8Test` from the sbt session.
// See http://www.foundweekends.org/giter8/testing.html#Using+the+Giter8Plugin for more details.
lazy val root = (project in file("."))
  .enablePlugins(ScriptedPlugin)
  .settings(
    name         := "zhttp",
    test in Test := {
      val _ = (g8Test in Test).toTask("").value
    },
    scriptedLaunchOpts ++=
      List(
        "-Xms1024m",
        "-Xmx1024m",
        "-XX:ReservedCodeCacheSize=128m",
        "-Xss2m",
        "-Dfile.encoding=UTF-8",
      ),
    resolvers +=
      Resolver.url("typesafe", url("https://repo.typesafe.com/typesafe/ivy-releases/"))(
        Resolver.ivyStylePatterns,
      ),
  )

addCommandAlias("fmt", "scalafmt; Test / scalafmt; sFix;")
addCommandAlias("fmtCheck", "scalafmtCheck; Test / scalafmtCheck; sFixCheck")
addCommandAlias("sFix", "scalafix OrganizeImports; Test / scalafix OrganizeImports")
addCommandAlias("sFixCheck", "scalafix --check OrganizeImports; Test / scalafix --check OrganizeImports")
