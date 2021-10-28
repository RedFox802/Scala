object Functions {

  /* a) Напишите функцию, которая рассчитывает площадь окружности r^2 * Math.PI*/
  def task1(r:Double):Double={Math.pow(r,2) * Math.PI}
  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testCircle(r: Double): Double = task1(r)
  

  /* b) Напишите карированную функцию которая рассчитывает площадь прямоугольника a * b.*/
  def task2 (a:Double)(b:Double): Double = a * b
  // примените вашу функцию из пукта (b) здесь, не изменяя сигнатуру
  def testRectangleCurried(a: Double, b: Double): Double = task2(a)(b)


  // c) Напишите не карированную функцию для расчета площади прямоугольника.
  def task3 (a:Double, b:Double): Double = a * b
  // примените вашу функцию из пункта (c) здесь, не изменяя сигнатуру
  def testRectangleUc(a: Double, b: Double): Double = task3(a,b)

  def main(args: Array[String]): Unit ={

    Console.println(testCircle(5))
    Console.println(testRectangleUc(2,4))
    Console.println(testRectangleCurried(2,4))

  }
}

