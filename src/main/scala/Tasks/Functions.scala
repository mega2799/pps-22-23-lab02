package Tasks

object Functions extends App

    def toPositive(number : Int) : String = 
        number match
            case number if number < 0 => "negative"
            case _ => "positive"

    val positiveVal : Int => String= _ match
        case n  => toPositive(n)
    
    def neg[X, Y](pred : X => Boolean) : X => Boolean =
        (x : X) => !pred(x)

    val p1 : Int => Int => Int => Boolean =  
        x => y => z => (x > y && y == z)

    val p2:(x : Int, y : Int, z : Int) => Boolean = 
        (x, y, z) => (x > y && y == z)

    def p3(x : Int)(y : Int)(z : Int): Boolean =
        x > y && y == z
        
    def p4(x : Int, y : Int, z : Int): Boolean = 
        x > y && y == z

    //il constraint e' il tipo degli argomenti, 
    // in questo caso potrebbere essere anche 3 domini diversi
    def compose[X, Y, Z ](f: Y => Z, g: X => Y ): X => Z =
        i  => f(g(i))
