package $package$

import zio.test._
import zio.test.Assertion._
import zhttp.http._

object $name;format="Camel"$Spec extends DefaultRunnableSpec {
  override def spec: ZSpec[Environment, Failure] = suite("""$name;format="Camel"$Spec""")(
    testM("200 ok") {
      checkAllM(Gen.fromIterable(List("text", "json"))) { uri =>
        val request = Request(Method.GET, URL(!! / uri))
        assertM(ZhttpService.app(request).map(_.status))(equalTo(Status.OK))
      }
    },
  )
}
