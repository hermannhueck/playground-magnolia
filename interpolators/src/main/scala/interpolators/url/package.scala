package interpolators

package object url {

  import contextual._
  import java.net.URL
  import scala.util.Try

  object UrlInterpolator extends Interpolator {

    type Output = Url

    override def contextualize(interpolation: StaticInterpolation) = {

      val lit @ Literal(_, urlString) = interpolation.parts.head

      if (!checkValidUrl(urlString))
        interpolation.abort(lit, 0, "not a valid URL")

      Nil
    }

    private def checkValidUrl(urlString: String): Boolean =
      Try(new URL(urlString)).fold(_ => false, _ => true)

    def evaluate(interpolation: RuntimeInterpolation): Url =
      Url(interpolation.literals.head)
  }

  implicit class UrlStringContext(sc: StringContext) {
    val url = Prefix(UrlInterpolator, sc)
  }
}
