package exercises

/**
 * @author JoseAntonio
 */
object IterableExercise {
  
  
  def main(arg : Array[String]){
    println("Iterables\n=========")
  
    val list1 = List(1,2,3,4,5,6,7,8,9,10)
    val it1 = list1.iterator
  
    while(it1.hasNext)
      printf(it1.next()+",")
  
    println("");
    
    val it2 = list1 sliding(2, 4)
    while(it2.hasNext)
      printf(it2.next()+",")
      
    println("")
    
    val list2 = List("Spain", "France", "Germany", "England")
    
    val list3 = list1 zipAll(list2, 0, "?")
    
    println(list3)

  }
 
}