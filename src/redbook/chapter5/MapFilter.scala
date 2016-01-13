package redbook.chapter5

/**
 * @author JoseAntonio
 */
object MapFilter {
  
  def main(arg : Array[String]){
    
    val list1 = List(1,2,3,4)
    println(list1)
    
    val list2 = list1 map (_ + 10) filter ( _ % 2 == 0) map (_ *3)
    println(list2)
  }
}