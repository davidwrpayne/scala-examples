package example

object ForCompExample2 extends App {


  case class Tweet(id: Int, content: String, author: Int)
  case class User(id: Int, name: String)

  val listUsers = List(
    User(1,"Jack"),
    User(2, "Jill"),
    User(3, "Rex"),
    User(4, "Harrison"),
  )

  val tweets = List(
    Tweet(1,"hello",1),
    Tweet(2,"I like tweeting", 2),
    Tweet(3, "So much in fact", 2),
    Tweet(4, "This is rex, rex rex rex", 3),
    Tweet(5, "world" , 1),
    Tweet(6, "Han solo is the best", 4),
    Tweet(7, "rex rex rex rex rex", 3),
    Tweet(8, "That I tweet all the time", 2)
  )

  val followed = List(
    (1,2),
    (1,3),
    (1,4),
    (2,4),
    (2,1),
    (3,4),
    (4,3)
  )


  // task : get all tweets for logged in user

  val user = getLoggedInUser()
  println("you're logged in as " + getUser(user).name)

  val result: List[(String, String)] = for {
    followed: Int <- getFollowed(user)
    tweet: Tweet <- getTweetsForUser(followed)
    fullUser: User = getUser(followed)
  } yield {
    (fullUser.name, tweet.content)
  }




  // get tweets of people who follow you?
  // get


  result.foreach( res => println(s"you follow ${res._1}, they tweeted \'${res._2}\'"))




  def getFollowed(id: Int): List[Int] = {
    println(followed)
    for (
      link <- followed if link._1 == id

    ) yield { link._2 }
  }
  def getTweetsForUser(id: Int): Seq[Tweet] = tweets.filter(_.author == id)

  def getLoggedInUser(): Int = {
    val r = new scala.util.Random(System.nanoTime())
    r.nextInt(4) + 1
  }

  def getUser(id: Int): User = listUsers.find(id == _.id).getOrElse(throw new Exception(s"No user with id $id"))
  def getTweet(id: Int): Tweet = tweets.find(id == _.id).getOrElse(throw new Exception(s"No tweet with id $id"))




}
