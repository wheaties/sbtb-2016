package exercise1

import scala.collection.mutable.{Set => MSet}

object Imperative{
  def largest(tree: Tree[Int]): List[Int] ={
    var search = (List.empty[Int], tree) :: Nil
    var list = List.empty[Int]
    var value = tree match{
      case Empty => 0
      case Node(v, _) => v
    }

    while(search.nonEmpty){
      val (seen, head) :: tail = search
      val calc = seen.sum
      search = head match{
      	case Empty => tail
        case Node(v, leaves) => 
          val current = seen :+ v
          if(value > v+calc){
          	value = v+calc
          	list = current
          }
          seenBefore += head
          leaves.map{ (current, _) } ::: tail
      }
    }
    list
  }
}