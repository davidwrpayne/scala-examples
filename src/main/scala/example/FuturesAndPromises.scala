package example

import scala.concurrent.{Await, Promise}
import scala.util.Try


object FuturesAndPromises extends App {
  val ec = scala.concurrent.ExecutionContext.global

val start = System.currentTimeMillis()


  def ComputeBigSum(): Int = {
    var totalSum = 0
    for (i <- 0 to 100000) {
      var sum = 0
      for (j <- 0 to i) {
        sum += i + j
      }
      totalSum += sum
    }
    totalSum
  }

  val promise = Promise[Int]()


  val task = new Runnable { def run() { val x = Try(ComputeBigSum())
    promise.complete(x)
  } }
  ec.execute(task)



  val f = promise.future
  import scala.concurrent.duration._
  Await.result(f, 10 seconds)
  val end = System.currentTimeMillis()


// This is pretty much the same as above
//  val fnew = Future  {
//      ComputeBigSum()
//  }

println("time was " + (end - start))
}
