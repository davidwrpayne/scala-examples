package example

import scala.concurrent.Future

object FuturesExample extends App {


    val ec = scala.concurrent.ExecutionContext.global

    // Simple Future work
    val fibNum = 100

    val futureFibonacciNumber = Future {
      val startTime = System.currentTimeMillis()
      var localVariable = 0

      for (i <- 1 to fibNum ) {
        localVariable = localVariable + i
      }
      val endTime = System.currentTimeMillis() - startTime
      println(s"Task took :$endTime millis")  // note the s at the start of this string, it signifies a interpolated string
      println(s"fibonacci of $fibNum = $localVariable")
      localVariable
    }(ec)  // this block of code will be scheduled and executed by the ExecutionContext ec.





}
