package derivations.show

sealed trait Tree[+T]                                      extends Product with Serializable
final case class Branch[+T](left: Tree[T], right: Tree[T]) extends Tree[T]
final case class Leaf[+T](value: T)                        extends Tree[T]

object Tree {

  import language.experimental.macros
  import magnolia._
  import cats.Show

  object ShowDerivation {

    type Typeclass[T] = Show[T]

    def combine[T](ctx: CaseClass[Show, T]): Show[T] = new Show[T] {

      def show(value: T): String = {
        val params =
          ctx
            .parameters
            .map { p =>
              s"${p.label}=${p.typeclass.show(p.dereference(value))}"
            }
            .mkString("{", ",", "}")
        // s"${ctx.typeName}$params"
        params
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
}
