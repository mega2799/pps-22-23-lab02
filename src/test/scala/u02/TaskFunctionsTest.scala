package u02

import junit.framework.TestCase.assertTrue
import org.junit.Assert.{assertEquals, assertFalse}
import org.junit.Test
import Tasks.*
import math.Fractional.Implicits.infixFractionalOps
import math.Integral.Implicits.infixIntegralOps
import math.Numeric.Implicits.infixNumericOps

class TaskFunctionsTest:
    // val functions = Functions

    def toPositiveMethod() =
        assertEquals("negative", toPositive(-22))
        assertEquals("positive", toPositive(22))
        assertEquals("positive", toPositive(0))

    
    def toPositiveVal() =
        assertEquals("negative", positiveVal(-22))
        assertEquals("positive", positiveVal(22))
        assertEquals("positive", positiveVal(0))
    
    @Test
    def checktoPositives() =
        toPositiveMethod()
        toPositiveVal()
    
    def negFunction() =
        val empty: String => Boolean = _ == "" // predicate on strings
        val notEmpty = neg(empty) // which type of notEmpty?
        assertTrue(notEmpty("foo")) // true
        assertFalse(notEmpty("")) // false
    

    @Test
    def negTest()=
        negFunction()
 
    def simpleCurry() = 
        assertTrue(p1(10)(3)(3))
        assertFalse(p1(10)(30)(30))
        assertFalse(p1(40)(30)(10))

    def nonCurryVal() = 
        assertTrue(p2(10, 3, 3))
        assertFalse(p2(10, 30, 30))
        assertFalse(p2(40, 30, 10))
    def nonCurryDef() =
        assertTrue(p4(10, 3, 3))
        assertFalse(p4(10, 30, 30))
        assertFalse(p4(40, 30, 10))
    
    def curryDef() =
        assertTrue(p3(10)(3)(3))
        assertFalse(p3(10)(30)(30))
        assertFalse(p3(40)(30)(10))

    @Test
    def curryingTest()=
        simpleCurry()
        curryDef()
        nonCurryDef()
        nonCurryVal()

    @Test
    def composeTest() =
        assertEquals(8.5, compose((i : Double)=> i - 1.5, (o : Double) => o * 2)(5.0), 0.0001)
        assertEquals(1900L, compose((i : Long)=> i - 100L, (o : Long) => o * 2)(1000L), 0.0001)