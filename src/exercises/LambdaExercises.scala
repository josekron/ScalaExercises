package exercises

/**
 * @author JoseAntonio
 */
object Lambda {
  def main(arg : Array[String]){
    println("An anonymous function can also take on a different look by taking out the brackets")
    
    def lambda = (x:Int) => x + 1
    
    val result1 = lambda(5)
    println(result1)
    
    println("Function returning another function")
    
    def lambda2(x:Int) = {
      new Function[Int, Int](){
        def apply(y:Int): Int = x + y
      }
    }
    
    val result2 = lambda2(3)
    println(result2.apply(1))
    
    println("We can take that closure and throw into a method and it will still hold the environment")
    
    def lambda3 (x:Int, y:Int => Int) = y(x)
    var incrementer = 3
    def closure = (x:Int) => x + incrementer
    
    val result3 = lambda3(3,closure)
    println(result3)
    
    println("Function returning another function using an anonymous function")
    
    def lambda4 (x:Int) = (y:Int) => x + y
    
    val result4 = lambda4(3).apply(1)//.isInstanceOf[Function1[Int,Int]]
    println(result4);
    
    println("Function taking another function as parameter. Helps in composing functions")
    
    def lambda5 (xs: List[String]) = xs map {_.toUpperCase()}
    
    val result5 = lambda5(List("hello", "friend", "goobbye"))
    println(result5)
  }
}