package exercise2

import scala.concurrent.Future

case object TooManyInBounds extends Exception("Too many concurrent requests.")
case class DoesNotExist(name: String) extends Exception(s"$name does not exist")

trait DBConn{
  def get[A](name: String, paginated: Int=100): Future[List[A]]
}