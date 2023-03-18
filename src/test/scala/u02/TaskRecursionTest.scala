package u02

import Tasks.gcd
import org.junit.Test
import org.junit.Assert.{assertEquals, assertFalse}

class TaskRecursion:

    @Test
    def baseCase()=
        assertEquals(4, gcd(4, 8))
        assertEquals(4, gcd(12, 8))
        assertEquals(7, gcd(14, 7))
        assertEquals(6, gcd(32580,3822))
