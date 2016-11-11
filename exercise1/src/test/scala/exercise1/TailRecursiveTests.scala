package exercise1

import org.scalatest.{ Matchers, WordSpec }

class TailRecursiveTests extends WordSpec with Matchers{
  val tree1 = Tree(1, Nil)
  val tree2 = Tree(1, List(
  	Tree(1, Nil),
  	Tree(2, Nil),
  	Tree(-1, List(Tree(7, Nil)))
  ))

  "Recursive" should{
  	"handle an empty list Tree" in{
  	  TailRecursive.largest(tree1) should equal(List(1))
  	}

  	"produce matching results" in{
  	  val imp = Imperative.largest(tree2)
  	  val rec = TailRecursive.largest(tree2)

  	  rec should equal (imp)
  	}

  	"handle this challenge" in{
  	  val tree3 = Tree(0, List(
  	  	Tree(1, List(
  	  	  Tree(1, List(Tree(1, Nil)))
  	  	)),
  	  	Tree(2, List(
  	  	  Tree(0, List(
  	  	  	Tree(1, List(
  	  	  	  Tree(0, Nil),
  	  	  	  Tree(0, Nil),
  	  	  	  Tree(0, Nil)
  	  	  	)),
  	  	  	Tree(-3, List(
  	  	  	  Tree(1, List(
  	  	  	  	Tree(1, Nil),
  	  	  	  	Tree(1, List(Tree(2, Nil))),
  	  	  	  	Tree(1, List(
  	  	  	  	  Tree(1, List(Tree(3, Nil)))
  	  	  	  	))
  	  	  	  ))
  	  	  	)),
  	  	  	Tree(5, Nil)
  	  	  )),
  	  	  Tree(7, List(
  	  	  	Tree(-1, List(
  	  	  	  Tree(-4, Nil),
  	  	  	  Tree(1, List(
                Tree(-4, Nil)
              ))
  	  	  	))
  	  	  ))
  	  	)),
  	  	Tree(1, List(
  	  	  Tree(2, List(
  	  	  	Tree(1, Nil),
  	  	  	Tree(-1, List(Tree(3, Nil)))
  	  	  ))
  	  	))
  	  ))

  	  Imperative.largest(tree3) should equal(TailRecursive.largest(tree3))
  	}
  }
}