package redbook.chapter11

import org.scalacheck.Gen;
import org.scalacheck.Prop.forAll;
import org.scalacheck.Prop;

/**
 * If F implements a map with a signature like above, it´s a Functor
 */
trait Functor[F[_]] {
  def map[A,B](fa: F[A])(f: A => B): F[B]

  def distribute[A,B](fab: F[(A, B)]): (F[A], F[B]) =
    (map(fab)(_._1), map(fab)(_._2))

  def codistribute[A,B](e: Either[F[A], F[B]]): F[Either[A, B]] = e match {
    case Left(fa) => map(fa)(Left(_))
    case Right(fb) => map(fb)(Right(_))
  }
}

trait Monad[M[_]] extends Functor[M] {
  def unit[A](a: => A): M[A]
  def flatMap[A,B](ma: M[A])(f: A => M[B]): M[B]

  def map[A,B](ma: M[A])(f: A => B): M[B] =
    flatMap(ma)(a => unit(f(a)))
  def map2[A,B,C](ma: M[A], mb: M[B])(f: (A, B) => C): M[C] =
    flatMap(ma)(a => map(mb)(b => f(a, b)))

  def sequence[A](lma: List[M[A]]): M[List[A]] =
    lma.foldRight(unit(List[A]()))((ma, mla) => map2(ma, mla)(_ :: _))

  def traverse[A,B](la: List[A])(f: A => M[B]): M[List[B]] =
    la.foldRight(unit(List[B]()))((a, mlb) => map2(f(a), mlb)(_ :: _))

  def _replicateM[A](n: Int, ma: M[A]): M[List[A]] =
    if (n <= 0) unit(List[A]()) else map2(ma, _replicateM(n - 1, ma))(_ :: _)

  def compose[A,B,C](f: A => M[B], g: B => M[C]): A => M[C] =
    a => flatMap(f(a))(g)

  def _flatMap[A,B](ma: M[A])(f: A => M[B]): M[B] =
    compose((_:Unit) => ma, f)(())

  def join[A](mma: M[M[A]]): M[A] = flatMap(mma)(ma => ma)

}

object MonadMain {
  
  /**
   * Generate randoms that combinate with the function f
   */
  def map2[A,B,C](
      ga: Gen[A], gb: Gen[B])(f: (A,B) => C): Gen[C] =
      ga flatMap (a => gb map (b => f(a,b)))
  
  def main(arg : Array[String]){   
    println("Monads\n======");
  }
  
  /**
   * Monads is an implementation of one of the minimal sets** of monadic combinators, satisfying the laws of associativity and identity.
   * **:
   * - init and flatMap.
   * - unit and compose.
   * - unit, map and join.
   */
}