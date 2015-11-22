package exercises

/**
 * @author JoseAntonio
 */
object TraversableExercises {
  
  def main(arg : Array[String]){
    println("Traversables\n==========")
    
    val list1 = List(List(1,2), List(3,4), List(5,6))
    
    val list2 = list1.flatMap(_.map(_ * 2))
    println(list2)
    
    val list3 = list2.flatMap(it => if (it % 3 == 0) Some(it) else None)
    println(list3)
    
    val list4 = (0 /: list2)(_-_) //foldLeft
    println(list4)
    
    val list5 = list2.foldRight(0)(_+_)
    println(list5)
    
    val list6 = list2.reduceLeft(_+_)
    println(list6)
    
    val list7 = list1.transpose
    println(list7)
    
    println(list2.mkString(">",",","<"))
    
    val st = new StringBuilder()
    st.append("Hello: ")
    list2.filter { x:Int => x % 3 == 0 }.addString(st, ",")
    println(st)
  }
}