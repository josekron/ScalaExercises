package exercises

object HelloWorldScala {
  def main(arg : Array[String]){
    println("Hello world from Scala!")
    
    /* Val -> inmutables (only read)
     * Var -> mutables (read-write)
     */
    
    println("Difference between val and var:\n")
    
    val ia = true
    val ib = 1  > 2
    println("Val ia: "+ia+", Val ib: "+ib)

    var ma:Int = 1
    ma = 2
    println("Var ma: "+ma)
    
    assert(ia!=ib, "fail assert val")
    
    val pt = new Point(1,2)
    pt.move(1, 1)
    println("Point pt: "+pt.toString())
    try{
      assert(pt.x==2)
    }catch{
       case _: AssertionError => 
         printf("AssertionError -> ")
         println("pt.x: "+pt.x)
    }
    
    val gandalf = new ClassWithValParameter("Gandalf")
    println(gandalf.name)
    
    println("Option:\n")
    
    val someValue: Option[String] = Some("I am wrapped in something")
    println(someValue.get)
    assert(someValue.get == "I am wrapped in something")
    
    val number: Option[Int] = None//Some(3)
    val result1 = number.fold(0)(_ * 3)
    assert(result1 == 0)
  }
  
}