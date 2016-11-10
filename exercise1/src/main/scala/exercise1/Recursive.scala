package exercise1

object Recursive{

  def largest(tree: Tree[Int]): List[Int] = tree.leaves match{
  	case Nil => tree.value :: Nil
  	case many => 
  	  val candidates = many.map{ largest(_) }
  	  val best = candidates.foldLeft(List.empty[Int]){
  	  	case (left, right) => if(left.sum <= right.sum) right else left
  	  }
  	  tree.value :: best
  }
}