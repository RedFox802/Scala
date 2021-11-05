package myLab3
sealed trait Option[A] {

  def map[B](f: A => B): Option[B]
  def flatMap[B](f: A => Option[B]): Option[B]
}
case class Some[A](a: A) extends Option[A] {

  def map[B](f: A => B): Option[B] = Some(f(a))
  def flatMap[B](f: A => Option[B]): Option[B] = f(a)
}
case class None[A]()     extends Option[A] {

  def map[B](f: A => B): Option[B] = None()
  def flatMap[B](f: A => Option[B]): Option[B] = None()
}

/** Напишите ваши решения в тестовых функциях.  */
object Compositions {

  // a) Используйте данные функции. Вы можете реализовать свое решение прямо в тестовой функции.
  // Нельзя менять сигнатуры 

  def testCompose[A, B, C, D](f: A => B)
                             (g: B => C)
                             (h: C => D): A => D = h.compose(g).compose(f)

    /**
   * Происходит объединение функций
   */


  // b) Напишите функции с использованием `map` и `flatMap`. Вы можете реализовать свое решение прямо в тестовой функции.
  // Нельзя менять сигнатуры 

  def testMapFlatMap[A, B, C, D](f: A => Option[B])
                                (g: B => Option[C])
                                (h: C => D): Option[A] => Option[D] = _ flatMap f flatMap g map h


  // c) Напишите функцию используя for. Вы можете реализовать свое решение прямо в тестовой функции.
  // Нельзя менять сигнатуры 

  def testForComprehension[A, B, C, D](f: A => Option[B])
                                      (g: B => Option[C])
                                      (h: C => D): Option[A] => Option[D] = {
    for {
      a <- _
      b <- f(a)
      c <- g(b)
    } yield h(c)
  }

  def Func1(x: Char): Int = (x + 1)*2
  def Func2(x: Int): Double = x*(x+1)*(x-1)
  def Func3(x: Double): Int = (x / 2).toInt
  def Func4(x: Char): Option[Int] = Some((x + 1)*2)
  def Func5(x: Int): Option[Double] = Some(x*(x+1)*(x-1))
  def Func6(x: Double): Int = (x / 2).toInt

  def main(args: Array[String]): Unit = {
    print("Task1 ")
    println(testCompose(Func1)(Func2)(Func3)('a')) // ascii of [space] is 32

    print("Task2 ")
    println(testMapFlatMap(Func4)(Func5)(Func6)(Some('a')))

    print("Task3 ")
    println(testForComprehension(Func4)(Func5)(Func6)(Some('a')))
  }
}
