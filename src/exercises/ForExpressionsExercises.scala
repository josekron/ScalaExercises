package exercises

/**
 * @author JoseAntonio
 */
object ForExpressionsExercises {
  
  def main(arg : Array[String]){
    
    val someNumbers = Range(0, 10)
    var sum = 0
    for (i <- someNumbers)
      sum += i
    
    println(sum)
    
    val xValues = Range(1, 5)
    val yValues = Range(1, 3)
    val coordinates = for {
      x <- xValues
      y <- yValues} yield (x, y)
      
    println(coordinates(4))
    
    val nums = List(List(1), List(2), List(3), List(4), List(5))

    val result = for {
      numList <- nums
      num <- numList
      if(num%2 == 0)
    } yield(num)
    
    println(result);
  }
}