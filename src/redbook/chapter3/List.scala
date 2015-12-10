package redbook.chapter3

/**
 * @author JoseAntonio
 * 
 * Singly-linked list
 */

sealed trait List[+A]

case object Nil extends List[Nothing] //empty list
case class Cons[+A] (head:A, tail: List[A]) extends List[A] //noempty list

object List {
  
  /** Pattern matching **/
  
  def head(ints: List[Int]) : Int = ints match {
    case Nil => 0
    case Cons(x,xs) => x
  }
  
  def tail(ints: List[Int]) : List[Int] = ints match {
    case Nil => Nil
    case Cons(_,xs) => xs
  }
  
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x,xs) => x + sum(xs)
  }
  
  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }


  def main(arg : Array[String]){
    println("Singly-linked list\n=================")

  }
}