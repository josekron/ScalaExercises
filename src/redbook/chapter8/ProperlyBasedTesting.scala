package redbook.chapter8

import org.scalacheck.Gen;
import org.scalacheck.Prop.forAll

/**
 * @author JoseAntonio
 */
trait ProperlyBasedTesting {
  
  trait Prop { 
    def check: Unit
    def &&(p: Prop): Prop }
  
  def listOf[A](a: Gen[A]): Gen[List[A]]
  
  def listOfN[A](n: Int, a: Gen[A]): Gen[List[A]]
  
  def forAll[A](a: Gen[A])(f: A => Boolean): Prop
 
}