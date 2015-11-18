package exercises

/**
 * @author JoseAntonio
 */
object InfixAndOthersExercises {
  
   class Stereo {
    def unary_+ = "on"
  
    def unary_- = "off"
  }
   
   
  case class Person(name: String){
    def loves(person: Person) = new Loves(this, person)
  }
  class Loves[A, B](val a: A, val b: B)

  def announceCouple(couple: Person Loves Person) = {
    couple.a.name + " is in love with " + couple.b.name
  }

  
  def main(arg : Array[String]){
    
    val g: String = "Check out the big brains on Brad!"
    
    println(g.indexOf('e'))
    println(g.indexOf('o',7))

    val stereo = new Stereo()
    println((+stereo))
    
    val p1 = new Person("Frank")
    val p2 = new Person("Maria")
    
    println(announceCouple(new Loves(p1,p2)))
    println(announceCouple(p1 loves p2));
  }
}