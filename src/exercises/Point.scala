package exercises

class Point(xc: Int, yc: Int){
  var x: Int = xc
  var y: Int = yc
  
  def move(dx: Int, dy: Int){
     x += dx
     y += dy
  }
  override def toString(): String = "("+x+", "+y+")"
}