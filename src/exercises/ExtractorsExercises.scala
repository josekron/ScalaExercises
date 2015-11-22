package exercises

/**
 * @author JoseAntonio
 */
object ExtractorsExercises {
  
  object Twice {
    def apply(x: Int): Int = x * 2
    def unapply(z: Int): Option[Int] = if (z%2 == 0) Some(z/2) else None
  }

  class Employee(val firstName: String,
               val middleName: Option[String],
               val lastName: String)

  object Employee {
    def unapply(x: Employee) =
      Some(x.lastName, x.middleName, x.firstName)
  }
  
  def main(arg : Array[String]){
    println("Extractors\n===========")
    
    val v1 = Twice(21)
    println(v1)
    
    val v2 = Twice.apply(21)
    println(v2)
    
    val singri = new Employee("Singri", None, "Keerthi")
    val Employee(a, b, c) = singri
    println(a+", "+b+", "+c)
  }
}