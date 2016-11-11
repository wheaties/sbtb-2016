package exercise2

import scala.concurrent.{Future, ExecutionContext}

/** Here we'd like to be able to make a DB request in a standard imperative flavored
 *  style but be able to handle several things at once:
 *  
 *  1. Pagination of the result set.
 *  2. Failure of any one of the requests with built in retry logic.
 *
 *  Assume that once a `Future` returns a `List` less than the `paginate` size, the
 *  overall request is complete and we have requested the full contents of the
 *  `collection`.
 */
class MakeRequest[A](conn: DBConn, 
	                 paginate: Int=100, 
	                 retry: Int=3)(implicit ex: ExecutionContext) 
    extends (String => Future[List[A]]){
  def apply(collection: String): Future[List[A]] = ???
}