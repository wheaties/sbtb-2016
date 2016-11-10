package presentation

sealed trait Tree
case class Node(left: Tree, right: Tree) extends Tree
case object Empty extends Tree