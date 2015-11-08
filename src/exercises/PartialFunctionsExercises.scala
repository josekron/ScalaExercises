package exercises

/**
 * @author JoseAntonio
 */
object PartialFunctionsExercises {
  
  def main(arg : Array[String]){
    println("Partially Applied Functions")
    
    def sum(a:Int, b:Int, c:Int) = a + b + c
    val sum1 = sum _
    
    println(sum1(1,2,3))
    
    val sum2 = sum(1,4, _:Int)
    
    println(sum2(2))
    
    println("Partial Functions")
    
    val partial1: PartialFunction[Int, Int] = new PartialFunction[Int, Int]{
      def isDefinedAt(x:Int) = x % 2 == 0
      def apply(v1: Int) = v1 * 2
    }
    
    val partial2: PartialFunction[Int, Int] = new PartialFunction[Int, Int]{
      def isDefinedAt(x:Int) = x % 2 != 0
      def apply(v1: Int) = v1 * 3
    }
    
    val res1 = partial1 orElse partial2
    println(res1(2))
    
    val res2 = partial1 orElse partial2 andThen (partial1 orElse partial2)
    println(res2(6))
    
  }
}