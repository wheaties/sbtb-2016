package presentation

object Imperative{
  def longest(tree: Tree): Int ={
    var search = (0, tree) :: Nil
    var value = 0
    while(search.nonEmpty){
      val (v, current) :: tail = search
      search = current match{
        case Node(Empty, Empty) => tail
        case Node(left, Empty) => (v+1, left) :: tail
        case Node(Empty, right) => (v+1, right) :: tail
        case Node(left, right) => (v+1, left) :: (v+1, right) :: tail
      }
      value = Math.max(value, v) //could move to case Node(Empty, Empty) =>
    }
    value
  }
}