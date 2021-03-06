package redbook.chapter2

/**
 * @author JoseAntonio
 */
object Factorial {
    
  def factorial(n: Int):Int = {
    
    @annotation.tailrec
    def go(n:Int, acc: Int):Int = {
      if(n<=0) acc
      else go(n-1, acc*n)
    }
    
    go(n,1)
  }
  
  def main(arg : Array[String]){
    println("Factorial\n=========")
    
    val n = 4
    println("Factorial of %d: %d".format(n,factorial(n)))
  }
}