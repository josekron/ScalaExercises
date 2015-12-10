package redbook.chapter2

/**
 * @author JoseAntonio
 */
object SortedSearch {
  
  def isSorted[@specialized A](as: Array[A], gt: (A,A) => Boolean): Boolean = {
    
    @annotation.tailrec 
    def go(a: Int, b: Int):Boolean = {
      if(b >= as.length) true
      else if (gt(as(a),as(b))) false
      else go(b,b+1)
    }  
    go(0, 1)  
  }
  
   def main(arg : Array[String]){
    println("IS SORTED\n=========")
    
    val as = Array(1,2,6,6,8)
    
    val res = isSorted(as, (x: Int, y:Int) => x > y)
    println(res)

  }
}