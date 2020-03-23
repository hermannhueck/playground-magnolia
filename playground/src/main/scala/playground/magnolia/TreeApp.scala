package playground.magnolia

import scala.util.chaining._

import cats.Show
import cats.instances.int._
import cats.syntax.show._

import playground.magnolia.show.ShowDerivation._

sealed trait Tree[+T]                                      extends Product with Serializable
final case class Branch[+T](left: Tree[T], right: Tree[T]) extends Tree[T]
final case class Leaf[+T](value: T)                        extends Tree[T]

object TreeApp extends util.App {

  val tree = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))

  Show[Tree[Int]].show(tree) pipe println

  // uses cats.syntax.show
  tree.show pipe println
}
