package exercises

import scala.collection.mutable

/**
 * @author JoseAntonio
 */
object MutableMapsAndSetsExercises {
  
  def main(arg : Array[String]){
    println("Mutable Maps\n============")
    
    val myMap = mutable.Map("SP" -> "Spain", "FR" -> "France")
    println(myMap.size)
    myMap ++= List("GE"->"Germany", "EN"->"England")
    println(myMap.size)
    myMap -= "FR"
    println(myMap.size)
    myMap.clear()
    println(myMap.size)
    
    println("Mutable Sets\n============")
    
    val mySet = mutable.Set("Spain", "France")
    println(mySet.size)
    mySet += "Germany"
    println(mySet.size)
    mySet --= List("France", "Germany")
    println(mySet.size)
    println(mySet contains "France")
  }
}