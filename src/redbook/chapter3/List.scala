package redbook.chapter3

/**
 * @author JoseAntonio
 * 
 * Singly-linked list
 */

sealed trait List[+A]

case object Nil extends List[Nothing] //empty list
case class Cons[+A] (head:A, tail: List[A]) extends List[A] //noempty list

object ListSL {
  
  /** Pattern matching **/
  
  def head(ints: List[Int]) : Int = ints match {
    case Nil => 0
    case Cons(x,xs) => x
  }

  def tail(ints: List[Int]) : List[Int] = ints match {
    case Nil => Nil
    case Cons(_,xs) => xs
  }
  
  def drop[A](l: List[Int], n: Int): List[Int] = {
    if (n==0) Cons(head(l),Nil)
    else Cons(head(l), drop(tail(l),n-1))
  }
  
  def dropWhile[A](l: List[Int])(f: Int => Boolean): List[Int] = {
    if(l == Nil) Nil
    else if(f(head(l))) Cons(head(l), dropWhile(tail(l))(f))
    else dropWhile(tail(l))(f)
  }
  
  def setHead[A](l: List[Int], n:Int):List[Int] = {
    if(l == Nil) Nil
    else Cons(n, tail(l))
  }
  
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x,xs) => x + sum(xs)
  }
  
  def product(ds: List[Int]): Int = ds match {
    case Nil => 1
    case Cons(0, _) => 0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }

  def max(n : Int, max:Int) : Boolean = {
    n < max
  }
  
  def foldRight[A,B](l: List[A], z: B)(f: (A, B) => B): B = l match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }
  
  def sum2(l: List[Int]) = foldRight(l, 0.0)(_ + _)
  
  def product2(l: List[Double]) = foldRight(l, 1.0)(_ * _)
  
  def length[A](l: List[Int]): Int = l match {
    case Nil => 0
    case Cons(x,xs) => 1 + length(xs)
  }

  def main(arg : Array[String]){
    println("Singly-linked list\n==================")
    
    val example = ListSL(1,2,3,4,5)
    val totalSum = sum(example)
    val totalProd = product(example)
    
    println("total sum: %d".format(totalSum))
    println("total product: %d".format(totalProd))
    
    val example2 = Cons(1, Cons(2, Cons(3, Cons(4, Cons(5, Nil)))))
    val totalSum2 = sum(example2)
    println("total sum2: %d".format(totalSum2))
    
    val list2 = drop(example, 2)
    println("Exercise 3: "+list2)
    
    val list3 = dropWhile(example)(max(_, 4))
    println("Exercise 4: "+list3)
    
    val list4 = setHead(example, 10)
    println("Exercise 5: "+list4)

    val list5 = length(example)
    println("Exercise 9: "+list5)
  }
}