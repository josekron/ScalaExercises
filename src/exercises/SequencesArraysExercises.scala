package exercises

import scala.collection.Seq

/**
 * @author JoseAntonio
 */
object SequencesArraysExercises {
  
  def main(arg : Array[String]){
    println("Sequences and Arrays\n============")
    
    val a = Array(1,2,3)
    println(a.toSeq)
    println(a.toList)
    
    val b = for(v <- 1 to 10 if v % 2 == 0) yield v
    println(b.toList)
    val c = b.toSeq;
    val filtered = c.filter { x => x % 3 == 0}
    println(filtered.toList)
    
    val mult = c map{x => x*2}
    println(mult.toList)
  }
}