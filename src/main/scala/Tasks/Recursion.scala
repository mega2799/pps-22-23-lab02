package Tasks
import math.Integral.Implicits.infixIntegralOps


object Recursion extends App
    @annotation.tailrec 
    def gcd(a: Int, b: Int): Int = 
        (a, b) match
            case (a,b) if b == 0 => a
            case _ => gcd(b, Math.floorMod(a,b)) 