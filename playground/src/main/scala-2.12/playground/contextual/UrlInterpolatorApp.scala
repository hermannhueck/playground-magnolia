package playground.contextual

import scala.util.chaining._
import interpolators.url._

object UrlInterpolatorApp extends util.App {

  val url: Url = url"http://www.propensive.com/"

  url pipe println
}
