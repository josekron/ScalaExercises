package redbook.chapter2

/**
 * @author JoseAntonio
 */
object Sorted {

  def binarySearch[A](as: Array[A], key: A, gt: (A,A) => Boolean): Int = {
    @annotation.tailrec
    def go(low: Int, mid: Int, high: Int): Int = {
      if (low > high) -mid - 1
      else {
        val mid2 = (low + high) / 2
        val a = as(mid2)
        val greater = gt(a, key)
        if (!greater && !gt(key,a)) mid2
        else if (greater) go(low, mid2, mid2-1)
        else go(mid2 + 1, mid2, high)
      }
    }
    
    go(0, 0, as.length - 1)
  }
  
  def main(arg : Array[String]){
    println("Binary Search\n======")
    
    val as = Array(1,4,6,3)
    val key = 4
    
    val res = binarySearch(as, key, (x: Int, y:Int) => x > y)
    println(res)

  }
}