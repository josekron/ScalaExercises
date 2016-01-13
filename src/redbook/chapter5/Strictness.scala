package redbook.chapter5

/**
 * @author JoseAntonio
 */
object Strictness {
  
  def square(x: Double): Double = x * x
  
  def if2[A](cond: Boolean, onTrue: => A, onFalse: => A): A =
    if (cond) onTrue else onFalse

  def main(arg : Array[String]){
    
    //A strictness function evaluates all parameters o returns error. Example:    
    println(square(2.0+3.0))
    
    //A non-strictness function doesn´t evaluate all parameters. Boolean are non-strictness.
    
    val res = false && { println("!!"); true }
    // only evaluates the second argument if the first argument is true
    println(res)
    
    val res2 = if2(false, sys.error("fail"), 3)//only evaluates one argument. "=>" means that not evaluate this argument.
    println(res2)
    
    // With lazy, the expression is evaluated in the first use.
    
    val x = { print ("foo") ; 10 }
    print ("bar")
    print (x)
    
    println("")
    
    lazy val y = { print ("foo") ; 10 }
    print ("bar")
    print (y)
  }
}