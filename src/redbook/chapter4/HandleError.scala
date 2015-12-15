package redbook.chapter4

import java.util.regex._
/**
 * @author JoseAntonio
 */

case class Employee(name: String, department: String)

object HandleError {
  
  def mean(xs: Seq[Double]) : Option[Double] = {
    if(xs.isEmpty) None
    else Some(xs.sum / xs.length)
  }
  
  def pattern(s: String): Option[Pattern] =
  try {
    Some(Pattern.compile(s))
  } catch {
    case e: PatternSyntaxException => None
  }

  def mean(xs: IndexedSeq[Double]): Either[String, Double] =
    if (xs.isEmpty)
      Left("mean of empty list!")
    else
      Right(xs.sum / xs.length)

  def main(arg : Array[String]){
    println("Handling errors\n===============")
    
    val v1 = Seq(1.1, 1.2, 1.3)
    val res1 = mean(v1)
    println("res1: %s".format(res1.get))
    
    val employeesByName: Map[String, Employee] = List(Employee("Alice", "R&D"), Employee("Bob", "Accounting")).map(e => (e.name, e)).toMap
    val dept1: Option[String] = employeesByName.get("Joe").map(_.department)
    val dept2: Option[String] = employeesByName.get("Alice").map(_.department)
    
    println("map: %s, %s".format(dept1,dept2.get))
    
    val dept3: String = employeesByName.get("Joe").map(_.department).filter(_ != "Accounting").getOrElse("Default Dept")
    
    println("filter: %s".format(dept3))
    
    val dept4: String = employeesByName.get("Joe").map(_.department).filter(_ != "Accounting").getOrElse(throw new Exception("fail!"))

  }
}