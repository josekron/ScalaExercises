package exercises

/**
 * @author JoseAntonio
 */
object EnumerationsExercises {
  
   object Planets extends Enumeration {

      val G = 6.67300E-11

      class PlanetValue(val i: Int, val name: String, val mass: Double, val radius: Double) extends Val(i: Int, name: String) {

        def surfaceGravity = G * mass / (radius * radius)

        def surfaceWeight(otherMass: Double) = otherMass * surfaceGravity

        def compare(that: PlanetValue) = this.i - that.i
     }
   }
  
   def main(arg : Array[String]){
    
    println("Enumerations\n============")
    
    val Mercury = new Planets.PlanetValue(0, "Mercury", 3.303e+23, 2.4397e6)
    val Venus = new Planets.PlanetValue(1, "Venus", 4.869e+24, 6.0518e6)
    
    println(Mercury.i+", "+Mercury.name+", "+Mercury.mass+", "+Mercury.radius)
    println(Mercury.i == Venus.i)
    
   }
}