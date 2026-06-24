package com.junit.assertions;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotSame;

public class AssertionsTest {
    @Test
    public void testAssertions() {
        assertEquals(10, 5 + 5);
        assertTrue(10 > 5);
        assertFalse(5 > 10);
        assertNull(null);
        assertNotNull(new Object());
        
        int[] expectedArray = {1, 2, 3};
        int[] actualArray = {1, 2, 3};
        assertArrayEquals(expectedArray, actualArray);
        
        Object obj1 = new Object();
        Object obj2 = obj1;
        Object obj3 = new Object();
        assertSame(obj1, obj2);
        assertNotSame(obj1, obj3);
    }
}
