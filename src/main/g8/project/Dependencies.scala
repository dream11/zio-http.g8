import sbt._

object Dependencies {
  val ZHTTPVersion = "$zhttpVersion$"

  val `zio-http` = "io.d11" %% "zhttp" % ZHTTPVersion
}
