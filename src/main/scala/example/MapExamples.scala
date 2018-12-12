package example

object MapExamples extends App {




  /**
    * Map is how you can string together functions
    */
    val list = List( "Hello", "World", "things", "are", "good")

    val result = list
      .map( s => s.toUpperCase )
      .map( upperCase => (upperCase, upperCase.size) )
      .map( tupleStringSize => (tupleStringSize._1.take(2), tupleStringSize._2) )
      .map( tupleShortSize => s"${tupleShortSize._1}${tupleShortSize._2}")

    println(result)

}
