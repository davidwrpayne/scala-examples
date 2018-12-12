package example

object TupleExample extends App {

  println("\n=== Tuple Creation ===")
  // Tuples can be created via class name
  val tupleOfSizeOne = Tuple1(5)
  println(tupleOfSizeOne)  // (5)

  val tupleOfSizeTwo = Tuple2(3,4)
  println(tupleOfSizeTwo) // (3,4)

  //Tuples can be created via syntactic shorthand.   (you'll see this used most often)
  val anotherTuple = (4,5)
  println(anotherTuple) // (4,5)

  // The type of a tuple is expressed using Parameters and types except for Tuples of size 1. (which you aren't likely to use)
  val tuple1: Tuple1[String] = Tuple1("stuff")
  val tuple2: (Int,Int) = Tuple2(6,8)


  println("\n=== Different Tuple Types for parameters ===")
  //Tuples can have different types for each parameter
  // lets define a simple class to use
  case class Student(name: String, age: Int)

  val danny = Student("Danny", 23)
  val tuple3: (Int, String, Student) = (5, "foo" , danny )
  println(tuple3) // (5,foo,Student(Danny,23))


  // You can extract the values using functions _{parameterNumber}

  println(tuple3._1) // 5
  println(tuple3._2) // foo
  println(tuple3._3) // Student(Danny,23)

  println("\n=== Tuple Named Value Extraction ===")
  // you can also extract parameters into named values.
  val (n: Int, myString: String, student: Student) = tuple3

  println(n) // 5
  println(myString) // foo
  println(student) // Student(Danny,23)


}
