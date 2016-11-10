package presentation

import scala.annotation.tailrec

object TailRecursive{
  def longest(tree: Tree): Int = find((0, tree) :: Nil, 0)

  @tailrec private def find(rem: List[(Int, Tree)], value: Int): Int = rem match{
    case Nil => value
    case (v, Node(Empty, Empty)) :: t => find(t, Math.max(v, value))
    case (v, Node(left, Empty)) :: t => find((v+1, left) :: t, value)
    case (v, Node(Empty, right)) :: t => find((v+1, right) :: t, value)
    case (v, Node(left, right)) :: t => find((v+1, left) :: (v+1, right) :: t, value)
  }
}