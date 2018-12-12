package example

object FilterExample extends App {


  val list = List( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  println(
    list.filter( n => n % 2 == 0)
  )

  println(
    list.filter( n => n % 3 == 0)
  )

  println(
    list.filterNot(n => n % 4 ==0 )
  )


}
