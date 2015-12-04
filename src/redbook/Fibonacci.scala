package redbook

/**
 * @author JoseAntonio
 */
object Fibonacci {
  
  def fibonacci(n1: Int, n2: Int, l: Int):Int = {
    
    @annotation.tailrec
    def go(n1:Int, n2: Int, l: Int):Int = {
      if(n2>l) n2
      else go(n2, n1+n2, l)
    }
    
    go(n1,n2,l)
  }
  
   def main(arg : Array[String]){
    println("Fibonacci\n=========")
    
    val n1 = 0
    val n2 = 1
    val limit = 5
    println("Fibonacci (%d , %d): %d".format(n1,n2, fibonacci(n1,n2,limit)))
  }
}