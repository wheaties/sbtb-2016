package exercise1

object Recursive{
  def largest(tree: Tree[Int]): List[Int] ={
	  val candidates = tree.leaves.map{ largest(_) }
	  val best = candidates.foldLeft(List.empty[Int]){
        case (Nil, right) => right
	  	case (left, right) => if(left.sum <= right.sum) right else left
	  }
	  tree.value :: best
  }
}