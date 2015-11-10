package exercises

/**
 * @author JoseAntonio
 */
object ImplicitParametersExercises {
  
  class ExampleWrapper(val original: Int){
    def isOdd = original % 2 != 0
    def isEven = !isOdd
  }
  implicit def exampleMethodImplicit(value: Int) = new ExampleWrapper(value)
  
  def exampleVarImplicit(hours: Int)(implicit dollarsPerHour: BigDecimal) = dollarsPerHour * hours
  implicit var hourlyRate = BigDecimal(34.00)

  def exampleArgumentDefault(hours:Int, days:Int = 5) = 
    (hours* days).toString() + " hours sleeping"
  
  def main(arg : Array[String]){
    println("Implicit Parameters")
    
    println(20.isOdd)
    println(20.isEven)
    
    println(exampleVarImplicit(30) )
    println(exampleArgumentDefault(2))
    
  }
}