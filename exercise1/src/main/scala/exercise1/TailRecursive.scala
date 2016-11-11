package exercise1

import scala.annotation.tailrec

object TailRecursive{
  def largest(tree: Tree[Int]): List[Int] ={
    @tailrec def _largest(
    	current: List[(List[Int], Tree[Int])], 
    	acc: List[Int] = Nil): List[Int] =
      current match{
      	case Nil => acc
      	case (trial, Tree(v, Nil)) :: tail if acc.isEmpty =>
      	  _largest(tail, trial :+ v)
      	case (trial, Tree(v, Nil)) :: tail =>
      	  _largest(tail, if(acc.sum <= trial.sum + v) trial :+ v else acc)
      	case (trial, Tree(v, leaves)) :: tail => 
      	  _largest(leaves.map{ (trial :+ v, _) } ::: tail, acc)
      }

    _largest((Nil, tree) :: Nil)
  }
}