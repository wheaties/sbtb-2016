package exercise1

case class Tree[+A](value: A, leaves: List[Tree[A]]) {
  def map[B](f: A => B): Tree[B] = Tree(f(value), leaves.map(_.map(f)))
}