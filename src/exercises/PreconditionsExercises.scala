package exercises

import org.scalatest.{ FlatSpec, Matchers, ParallelTestExecution }
import org.scalatest.concurrent.{ ScalaFutures, AsyncAssertions, PatienceConfiguration }
import concurrent.Future
import concurrent.ExecutionContext.Implicits._
import util._ 


/**
 * @author JoseAntonio
 */
object PreconditionsExercises extends FlatSpec with Matchers with ScalaFutures with ParallelTestExecution with AsyncAssertions{
  
  class Rational(n: Int, d: Int) {
    require(d != 0)
    override def toString = n +"/"+ d
  }
  
  class WithParameterRequirement(val myValue: Int) {
    require(myValue != 0)

    def this(someValue: String) {
      this(someValue.size)
    }
  }
  
  def main(arg : Array[String]){
    println("Preconditions\n=============")
  

    try{
      val v1 = new Rational(1,0)
    }catch{
       case _: IllegalArgumentException => 
         println("IllegalArgumentException -> d!=0")
    }
    
    val myInstance = new WithParameterRequirement("Do you really like my hair?")
     myInstance.myValue should be (27)
    
    intercept[IllegalArgumentException] {
      println("intercept IllegalArgumentException")
      new WithParameterRequirement("")
    }
  }
}