package exercises

/**
 * @author JoseAntonio
 */
object CaseClassesExercises {
  
  abstract class Term
  case class Person(name:String, age:Int=0) extends Term
  
  def main(arg : Array[String]){
    
    val v1 = Person("jose", 23)
    println(v1.toString())
    
    val v2 = Person("Maria")
    println(v2.toString())
    
    val v3 = v2.copy(age = 24)
    println(v3)
    
    println((v2 eq v3))
    
    println(v2.isInstanceOf[Serializable])
    
    val parts = Person.unapply(v3).get
    println(parts._1)
    println(parts._2)
  }
}