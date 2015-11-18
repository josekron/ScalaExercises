package exercises

/**
 * @author JoseAntonio
 */
object TraitExercises {
  
  trait ExampleTrait{
    def isSimilar(x:Any): Boolean
    def isNotSimilar(x: Any) : Boolean = !isSimilar(x)
    def check(x:Any): String
  }
  
  class Point(xc: Int, yc: Int) extends ExampleTrait {
    var x: Int = xc
    var y: Int = yc
    
    def isSimilar(obj: Any) = obj.isInstanceOf[Point] && obj.asInstanceOf[Point].x == x
    
    def check(obj: Any) : String = {
      obj match{
        case "hello" => "hello friend"
        case _ => "what time is it?"
      }
    }
  }
  
  
  def main(arg : Array[String]){
    
    println("Traits\n=====")
    
    var p1 = new Point(2,3)
    var p2 = new Point(4,4)
    
    println(p1.isSimilar(p1))
    println(p1.isSimilar(p2))
    println(p1.isSimilar(2))
    println(p2.isNotSimilar(p1))
    
    println(p1.check("hello"))
    println(p1.check())
  }
}