package readbook.chapter10

object MonoidMain {
  
  trait Monoid[A]{
    def op(a1: A, a2: A): A
    def zero: A
    
  }
  
  trait Monoid2[A]{
    def foldRight(z: A)(f: (A, A) => A): A
    def foldLeft(z: A)(f: (A, A) => A): A  
    def concatenate[A](as: Monoid2[A])(m: Monoid2[A]): A
  }
  
  trait Foldable[F[_]] {
    def foldRight[A, B](as: F[A])(f: (A, B) => B): B
    def foldLeft[A, B](as: F[A])(f: (B, A) => B): B
    def foldMap[A, B](as: F[A])(f: A => B)(mb: Monoid[B]): B
    def concatenate[A](as: F[A])(m: Monoid[A]): A
  }
  
  def main(arg : Array[String]){   
    println("Monoids\n=======");
    
    val stringMonoid = new Monoid[String] {
      def op(a1: String, a2: String) = a1 + a2
      def zero = ""
    }
    
    println("op: "+stringMonoid.op("hello", "world"))
    println("zero: "+stringMonoid.zero);
    
    val listMonoid = new Monoid[List[Integer]] {
      def op(a1: List[Integer], a2: List[Integer]) = a1 ++ a2
      def zero = Nil
    }
    
    listMonoid.op(List(1,2,3), List(4))
    println(listMonoid.op(List(1,2,3), List(4)))
    
    val intMonoid = new Monoid[Integer] {
      def op(a1: Integer, a2: Integer) = a1 + a2
      def zero = 0
      def intMultiplication(a1: Integer, a2: Integer) = a1 * a2
    }
    
    println(intMonoid.intMultiplication(2, 5))
    
    val boolMonoid = new Monoid[Boolean] {
      def op(a1: Boolean, a2: Boolean) = a1 & a2
      def or(a1: Boolean, a2: Boolean) = a1 | a2
      def zero = false
    }

    println(boolMonoid.op(true, false))
    println(boolMonoid.or(true, false))
  }
}