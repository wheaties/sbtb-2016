package exercise1

object Imperative{
  def largest(tree: Tree[Int]): List[Int] ={
    var search = tree.leaves.map{ (List(tree.value), _) }
    var list = tree.value :: Nil
    var value = tree.value

    while(search.nonEmpty){
      val (seen, Tree(v, leaves)) :: tail = search
      val calc = seen.sum + v
      val current = seen :+ v
      if(value <= calc && leaves.isEmpty){
        value = calc
        list = current
      }
      search = leaves.map{ (current, _) } ::: tail
    }
    list
  }
}