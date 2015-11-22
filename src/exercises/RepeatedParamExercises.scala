package exercises

/**
 * @author JoseAntonio
 */
object RepeatedParamExercises {
  def main(arg : Array[String]){
    println("Repeated Parameters\n==================")
    
    def repeatedParameterMethod(x: String, y: String, z: Any*) = {
      "Hello %s and %s and your friends: %s".format(x, y, z.mkString(", "))
    }
    
    val v1 = repeatedParameterMethod("Maria", "Jose", "Frank", "Paco", "Ana")
    println(v1)
  }
}