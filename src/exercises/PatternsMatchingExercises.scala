package exercises

/**
 * @author JoseAntonio
 */
object PatternsMatchingExercises{
  
  def matchTest1(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }
  
  val name = "Paco";
  
  def matchTest2(expr: Any) : Any = expr match {
    case ("Jose", "Málaga") => ("Jose lives in Málaga")
    case ("Maria", "Madrid") => ("Maria lives in Madrid")
    case ("Fran", "Cádiz") => ("Fran lives in Cádiz")
    case ("Antonio", _) => ("Antonio lives in a car")
    case ("Marta", place) => ("Antonio lives in "+place)
    case (`name`, _) => ("Hi "+name)
    case _ => "I don´t know"
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
  
  def main(arg : Array[String]){
    
    println(PatternsMatchingExercises.matchTest1(4))
    
    println(PatternsMatchingExercises.matchTest2(("Jose","Málaga")))
    println(PatternsMatchingExercises.matchTest2(("Antonio","wololo")))
    println(PatternsMatchingExercises.matchTest2(("Marta","Paris")))
    println(PatternsMatchingExercises.matchTest2(("Paco","Paris")))
    
    println(PatternsMatchingExercises.matchTest3(2, 2))
    println(PatternsMatchingExercises.matchTest3(2, 1))
    
    println(PatternsMatchingExercises.matchTestSecondList)
  }
}