object Maps {

  case class User(name: String, age: Int)

  /* a) В данной Seq[User] сгруппируйте пользователей по имени (`groupBy`) и вычислите средний возраст: `name -> averageAge`*/
  def testGroupUsers(users: Seq[User]): Map[String, Int] = {
    def srage(num:Seq[Int])=num.sum/num.length

    users.groupBy(_.name).map{
      myKey=>(myKey._1, srage(myKey._2.map(_.age)))
    }
  }


  /* b) Дана `Map[String, User]` состоящая из имен пользователей `User`, сколько имен пользователей, содержащихся в Map, содержат подстроку "Adam"?*/
  def testNumberFrodos(map: Map[String, User]): Int = {
    map.count(x=>x._2.name=="Adam")
  }


  /* c) Удалите всех пользователей возраст которых менее 35 лет.*/
  def testUnderaged(map: Map[String, User]): Map[String, User] = {
      map.filter(x=>x._2.age>35)
  }

  def main(args: Array[String]) = {
    println("Task1:")
    println(testGroupUsers(Seq(User("Tanya",20),User("Tanya",56),User("Sonya",21),User("Sonya",81),User("Olya",5))))
    println("Task2:")
    var map=Map("One"->User("Adam",12),"Two"->User("Adam",15),"Three"->User("Alla",46))
    println(testNumberFrodos(map))
    println("Task3:")
    println(testUnderaged(map))
  }
}
