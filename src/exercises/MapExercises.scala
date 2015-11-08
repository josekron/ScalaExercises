package exercises

/**
 * @author JoseAntonio
 */
object MapExercises {
  def main(arg : Array[String]){
    printf("Map Exercises")
    
    val myMap = scala.collection.mutable.Map.empty[String, Any]
    myMap("car") = ("Dacia","Seat","Citroen")
    myMap("bike") = ("Honda","Yamaha")
    println(myMap.toString())
    
    val myMap2 = myMap - ("car")
    println(myMap2.toString())
    
    myMap("city") = ("Madrid", "Malaga", "Barcelona")
    val myMap3 = myMap -- List("bike", "city")
    println(myMap3)
    
    /*intercept-> the exception you got is expected, and not cause by program error.*/
//    var blewWithException = true
//    intercept[NoSuchElementException] {
//      myMap("MI")
//      blewWithException = false
//    }
    
  }
}