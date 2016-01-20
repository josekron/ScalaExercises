package redbook.chapter7

/**
 * @author JoseAntonio
 */
object FunctionalLibrary {

  
  def sum(as: IndexedSeq[Int]): Int =
    if (as.size <= 1) as.headOption getOrElse 0
    else {
      val (l,r) = as.splitAt(as.length/2)
      sum(l) + sum(r)
    }
  
//  def sum2(as: IndexedSeq[Int]): Int =
//    if (as.size <= 1) as.headOption getOrElse 0
//    else {
//      val (l,r) = as.splitAt(as.length/2)
//      val sumL: Par[Int] = Par.unit(sum(l))
//      val sumR: Par[Int] = Par.unit(sum(r))
//      Par.get(sumL) + Par.get(sumR)
//    }
//  
//  def sum3(as: IndexedSeq[Int]): Par[Int] =
//    if (as.size <= 1) Par.unit(as.headOption getOrElse 0)
//    else {
//      val (l,r) = as.splitAt(as.length/2)
//      this.Par.map2(sum(l), sum(r))(_ + _)
//  }
//  
//  def async[A](a: => A): Par[A] = fork(unit(a))
  
  def main(arg : Array[String]){
    
    val as = Array(1,2,3)
    val res = this.sum(as)
    println(res)

  }
}