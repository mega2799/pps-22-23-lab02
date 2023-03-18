package Tasks

import java.math.MathContext
import math.{ sqrt, pow }
import u02.Optionals

object TaskLab2:

    // Task 2
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

    // Task 3 
    object Recursion extends App
        @annotation.tailrec 
        def gcd(a: Int, b: Int): Int = 
            (a, b) match
                case (a,b) if b == 0 => a
                case _ => gcd(b, Math.floorMod(a,b)) 
    // Task 4
    object Gemoetric extends App:
        enum Shape:
            case Rectangle(base : Double, h : Double)
            case Circle(radius : Double)
            case Square(edge: Double)

            
        def perimeter(shape: Shape): Double =
            shape match
                case Shape.Rectangle(base, h) => (base + h) * 2
                case Shape.Circle(radius) => Math.PI * 2 * radius
                case Shape.Square(edge) => edge * 4

        def contains(shape: Shape, point: (Double, Double)): Boolean  =
            shape match
                case Shape.Rectangle(base, h) => Math.abs(point._1) <= base/2 && Math.abs(point._2) <= h/2
                    || Math.abs(point._1) <= h/2 && Math.abs(point._2) <= base/2
                case Shape.Circle(radius) => distance(point) <= radius 
                case Shape.Square(edge) => Math.abs(point._1) <= edge && Math.abs(point._2) <= edge

        def distance(other: (Double, Double)): Double =
            sqrt(pow(0.0 - other._1, 2) + pow(0.0 - other._2, 2))

    // Task 5
    object FuncitonalCombinators extends App:
        enum Option[A]:
            case Some(a: A)
            case None() // here parens are needed because of genericity

        object Option:
            def isEmpty[A](opt: Option[A]): Boolean = opt match
            case None() => true
            case _ => false

            def orElse[A, B >: A](opt: Option[A], orElse: B): B = opt match
            case Some(a) => a
            case _ => orElse

            def flatMap[A, B](opt: Option[A])(f: A => Option[B]): Option[B] = opt match
            case Some(a) => f(a)
            case _ => None()

            def filter[A](opt: Option[A])(f: A => Boolean) : Option[A] =
                opt match
                    case Some(a) if f(a) => Some(a)
                    case Some(a) if !f(a) => None()
                    case _ if isEmpty(opt) => None() 
                
            def map[A](opt: Option[A])(f: A => Boolean) : Option[Boolean] =
                opt match
                    case Some(a) if f(a) => Some(true)
                    case Some(a) if !f(a) => Some(false)
                    case _ if isEmpty(opt) => None() 

            def fold[A](opt: Option[A])(default : A)(f: A => A): A =
                opt match
                    case Some(a) => f(a)
                    case _ => default
