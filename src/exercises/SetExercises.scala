package exercises

/**
 * @author JoseAntonio
 */
object SetExercises {
  
  def main(arg : Array[String]){
    val mySet1 = Set(1,2,3,4);
    for(i <- mySet1)
      printf(i+",");
    
    println("");
    
    val mySet2 = Set("Madrid","Barcelona", "M�laga", "C�diz");
    val mySet3 = Set("C�rdoba", "Sevilla", "M�laga", "Granada", "C�diz");
    
    println(mySet2 - "Madrid");
    println(mySet2 -- List("Madrid", "Barcelona"));
    println("Union: "+(mySet2 union mySet3));
    println("Intersect: "+(mySet2 intersect mySet3));
    println("Diff: "+(mySet2 diff mySet3));
    
    val mySet4 = Set("Barcelona", "C�diz");
    
    println("SubsetOf: "+(mySet4 subsetOf(mySet2)));
  }
}