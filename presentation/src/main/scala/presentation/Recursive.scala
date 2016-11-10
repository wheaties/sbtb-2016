package presentation

object Recursive{
  def longest(tree: Tree): Int = tree match{
    case Node(Empty, Empty) => 0
    case Node(left, Empty) => 1 + longest(left)
    case Node(Empty, right) => 1 + longest(right)
    case Node(left, right) => 1 + Math.max(longest(left), longest(right))
  }
}