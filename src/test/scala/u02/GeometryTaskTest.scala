package u02

import org.junit.Test
import org.junit.Assert.{assertEquals, assertFalse, assertTrue}

import Tasks.TaskLab2.Gemoetric
import Tasks.TaskLab2.Gemoetric.contains
import Tasks.TaskLab2.Gemoetric.perimeter
import Tasks.TaskLab2.Gemoetric.Shape

class GeometryTaskTest:
    
    @Test
    def checkPerimeters()=
        assertEquals(12,perimeter(Shape.Rectangle(2, 4)), 1e-12)
        assertEquals(16,perimeter(Shape.Square(4)), 1e-12)
        assertEquals(Math.PI * 4 * 2,perimeter(Shape.Circle(4)), 1e-12)

    @Test
    def easyContains()=
        assertTrue(contains(Shape.Rectangle(2, 4), (0,0)))
        assertTrue(contains(Shape.Square(4), (0,0)))
        assertTrue(contains(Shape.Circle(4), (0,0)))

    @Test
    def difficoultContains()=
        assertTrue(contains(Shape.Rectangle(4, 2), (1,1)))
        assertTrue(contains(Shape.Rectangle(16, 4), (-3,2)))
        assertTrue(contains(Shape.Rectangle(16, 4), (-3,-2)))
        assertTrue(contains(Shape.Circle(16), (-3,-2)))
        assertFalse(contains(Shape.Circle(16), (16,16)))
        assertTrue(contains(Shape.Circle(16), (4,4)))
        assertTrue(contains(Shape.Square(4), (-2,2)))
