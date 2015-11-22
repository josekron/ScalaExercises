package exercises

/**
 * @author JoseAntonio
 */
object ByNameParameterExercises {
  
  def main(arg : Array[String]){
    println("ByName Parameters\n=================")
    
    def calc(x: => Int): Either[Throwable, Int] = {//x is a call by name parameter
      try {
        Right(x)
      } catch {
        case b: Throwable => Left(b)
      }
    }

    val y = calc {
      49 + 20
    }
    println(y)
    
  }
}