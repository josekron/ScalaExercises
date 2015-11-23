package exercises

import org.scalatest.matchers.ShouldMatchers

/**
 * @author JoseAntonio
 */
object TypeVarianceExercises {
  
  class Fruit

  abstract class Citrus extends Fruit

  class Orange extends Citrus

  class Tangelo extends Citrus

  class Apple extends Fruit

  class Banana extends Fruit
  
  class MyContainer[+A](a: A)(implicit manifest: scala.reflect.Manifest[A]) {
    private[this] val item = a

    def get = item

    def contents = manifest.runtimeClass.getSimpleName
  }
  
  def main(arg : Array[String]){
    
    println("Type variance\n=============")

    val fruitBasket = new MyContainer(new Orange())
    println(fruitBasket.contents)
    
    val fruitBasket2: MyContainer[Fruit] = new MyContainer[Citrus](new Orange())
    println(fruitBasket2.contents)
  }
}