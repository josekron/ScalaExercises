package exercises

/**
 * @author JoseAntonio
 */
object PatternsMatchingExercises{
  
  def main(arg : Array[String]){
    
     def matchTest1(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
    }
  
  val name = "Paco";
  
  def matchTest2(expr: Any) : Any = expr match {
    case ("Jose", "M�laga") => ("Jose lives in M�laga")
    case ("Maria", "Madrid") => ("Maria lives in Madrid")
    case ("Fran", "C�diz") => ("Fran lives in C�diz")
    case ("Antonio", _) => ("Antonio lives in a car")
    case ("Marta", place) => ("Antonio lives in "+place)
    case (`name`, _) => ("Hi "+name)
    case _ => "I don�t know"
  }
  
  def matchTest3(i:Int, j:Int) = j match {
    case `i` => true
    case _ => false
  }
  
  //xs is interpreted as the rest of the list
  def matchTestSecondList = List(1,2,3) match {
    case x :: xs => xs.head
    case _ => 0
  }
    
    println(matchTest1(4))
    
    println(matchTest2(("Jose","M�laga")))
    println(matchTest2(("Antonio","wololo")))
    println(matchTest2(("Marta","Paris")))
    println(matchTest2(("Paco","Paris")))
    
    println(matchTest3(2, 2))
    println(matchTest3(2, 1))
    
    println(matchTestSecondList)
  }
}