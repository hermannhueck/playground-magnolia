package playground.magnolia.show

import cats.Show
import language.experimental.macros
import magnolia._

object ShowDerivation {

  type Typeclass[T] = Show[T]

  def combine[T](caseClass: CaseClass[Show, T]): Show[T] = new Show[T] {

    def show(value: T): String = {
      val params =
        caseClass
          .parameters
          .map { p =>
            s"${p.label}=${p.typeclass.show(p.dereference(value))}"
          }
          .mkString("(", ",", ")")
      val prefix = caseClass.typeName.short
      s"$prefix$params"
    }
  }

  def dispatch[T](ctx: SealedTrait[Show, T]): Show[T] =
    new Show[T] {

      def show(value: T): String = ctx.dispatch(value) { sub =>
        sub.typeclass.show(sub.cast(value))
      }
    }

  implicit def gen[T]: Show[T] = macro Magnolia.gen[T]
}
