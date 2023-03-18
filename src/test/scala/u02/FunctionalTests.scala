package u02

package u02

import org.junit.Test
import org.junit.Assert.{assertEquals, assertFalse, assertTrue}
import Tasks.* 
import Tasks.FuncitonalCombinators.Option.*

class FunctionalTests:
    @Test
    def filterTest()=
        assertEquals(Some(5), filter(Some(5))(_ > 2)) // Some(5)
        assertEquals(None(), filter(Some(5))(_ > 8)) // None
        assertEquals(None(), filter(None[Int]())(_ > 2)) // None

    @Test
    def mapTest()=
        assertEquals(Some(true), map(Some(5))(_ > 2)) // Some(5)
        assertEquals(Some(false), map(Some(5))(_ > 8)) // None
        assertEquals(None(), map(None[Int]())(_ > 2)) // None

    @Test
    def foldTest()=
        assertEquals(6, fold(Some(5))(1)(_ + 1)) 
        assertEquals(1, fold(None[Int]())(1)(_ + 1)) 