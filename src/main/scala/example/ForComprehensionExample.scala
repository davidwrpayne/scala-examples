package example

object ForComprehensionExample extends App {

  // Intent of this example: produce list of the product of each combination of numbers except the same number.
  val list = List(1, 2, 3, 4)

  val result = for {
    num <- list
    num2 <- list
    prod = num * num2 if num != num2
  } yield {
    prod
  }

  println(result)


  /**
    * the above for comprehension is being turned into
    * the below
    */
  val result2 = list.flatMap(num => {
    list.map(num2 => (num, num2))
      .filter(input => {
        input._1 != input._2
      })
      .map(input => input._1 * input._2)
  })

  println(result)


  /**
    * Example taken from
    * https://gleichmann.wordpress.com/2010/11/21/functional-scala-comprehending-comprehensions/
    */
  case class Company(val name: String, val region: String, val avgSalary: Int)

  case class Employee(val name: String, val companyName: String, val age: Int)

  val companies = List(Company("SAL", "HE", 2000),
    Company("GOK", "DA", 2500),
    Company("MIK", "DA", 3000))

  val employees = List(Employee("Joana", "GOK", 20),
    Employee("Mikey", "MIK", 31),
    Employee("Susan", "MIK", 27),
    Employee("Frank", "GOK", 28),
    Employee("Ellen", "SAL", 29))

  // Consider if we were interested in the following
  //  only employees with age greater than 25
  //  only employees working for a company in region “DA”
  //  only employees with a higher salary than the average salary of the company they are working for
  //  (given a salary which is calculated by the employees age times 100)

  val endResult =
    for (e <- employees;
         if e.age > 25;
         salary = e.age * 100;

         c <- companies
         if c.region == "DA";
         if c.name == e.companyName;
         if c.avgSalary < salary
    )
      yield (e.name, c.name, salary - c.avgSalary)

  println(endResult) // List(  (Mikey, MIK, 100),  (Frank, GOK, 300)  )


}
