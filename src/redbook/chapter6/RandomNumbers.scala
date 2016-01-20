package redbook.chapter6

/**
 * @author JoseAntonio
 */
object RandomNumbers {
  

  
  def main(arg : Array[String]){
    
    val rng = new java.util.Random
    
    println(rng.nextDouble())
    println(rng.nextInt())

  }
}