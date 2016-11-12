package presentation

import twotails.mutualrec

final class MutualTailRecursion{
  @mutualrec def ping(x: Int, times: Int=0): Int =
    if(x < 1) times else pong(x-1, times+1)

  @mutualrec def pong(x: Int, times: Int=0): Int =
    if(x < 0) pong(-x, times) else ping(x-1, times+1)
}

final class WithoutPlugin{
  def ping(x: Int, times: Int=0): Int =
    if(x < 1) times else pong(x-1, times+1)

  def pong(x: Int, times: Int=0): Int =
    if(x < 0) pong(-x, times) else ping(x-1, times+1)
}