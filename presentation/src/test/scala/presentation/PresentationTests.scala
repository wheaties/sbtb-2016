package presentation

import org.scalatest.{ Matchers, WordSpec }

class PresentationTests extends WordSpec with Matchers{
  def mkTree0(left: Tree, right: Tree, times: Int): Tree = 
    if(times < 1) Node(left, right) else mkTree0(Node(left, right), Node(left, right), times-1)

  def mkTree(times: Int): Tree = mkTree0(Empty, Empty, times)

  "Imperative" should {
  	val tree = mkTree(10)
  	val tree2 = Node(tree, mkTree(5))

  	"match results from Recursive" in{
  	  val rec = Recursive.longest(tree)
  	  val imp = Imperative.longest(tree)

  	  rec should equal (10)
  	  imp should equal (rec)
  	}

  	"match results from Recursive with uneven trees" in{
  	  val rec = Recursive.longest(tree2)
  	  val imp = Imperative.longest(tree2)

  	  rec should equal (11)
  	  imp should equal (rec)
  	}

  	"match results from TailRecursive" in{
  	  val rec = TailRecursive.longest(tree)
  	  val imp = Imperative.longest(tree)

  	  rec should equal (10)
  	  imp should equal (rec)
  	}

  	"match results from TailRecursive with uneven trees" in{
  	  val rec = TailRecursive.longest(tree2)
  	  val imp = Imperative.longest(tree2)

  	  rec should equal (11)
  	  imp should equal (rec)
  	}
  }
}