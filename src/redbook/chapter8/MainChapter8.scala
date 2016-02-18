package redbook.chapter8

import org.scalacheck.Gen;
import org.scalacheck.Prop.forAll

object MainChapter8 {
  
   def main(arg : Array[String]){
    
    val intList = Gen.listOf(Gen.choose(0,100))//Generate integers between 0 and 100
    val prop = 
      forAll(intList)(l => l.reverse.reverse == l) &&
      forAll(intList)(l => l.headOption == l.reverse.lastOption)
        
    val failingProp = forAll(intList)(l => l.reverse == l)

    println(prop.check);
    println(failingProp.check);
    
    val intChoose = Gen.choose(0, 10);
    println(intChoose);
  }
}