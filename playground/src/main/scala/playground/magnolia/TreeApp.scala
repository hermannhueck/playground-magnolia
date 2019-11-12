package playground.magnolia

import scala.util.chaining._

import cats.Show
import cats.instances.int._
import cats.syntax.show._

import derivations.show._
import derivations.show.Tree.ShowDerivation.gen

object TreeApp extends util.App {

  val tree = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))

  Show[Tree[Int]].show(tree) pipe println

  // uses cats.syntax.show
  tree.show pipe println
}
