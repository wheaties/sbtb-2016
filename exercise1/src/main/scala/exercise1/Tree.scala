package exercise1

sealed trait Tree[+A]{
  def map[B](f: A => B): Tree[B]
}
case class Node[+A](value: A, leaves: List[Tree[A]]) extends Tree[A]{
  def map[B](f: A => B): Tree[B] = Node(f(value), leaves.map(_.map(f)))
}
case object Empty extends Tree[Nothing]{
  def map[B](f: Nothing => B): Tree[B] = this
}