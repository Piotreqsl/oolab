package agh.ics.oop;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        assertEquals("(8,7)", new Vector2d(8, 7).toString());
        assertNotEquals("(3,2)", new Vector2d(2, 3).toString());
    }

    @Test
    void precedes() {
        Vector2d vector1 = new Vector2d(1,2);
        Vector2d vector2 = new Vector2d(2,3);
        Vector2d vector3 = new Vector2d(3,3);
        Vector2d vector4 = new Vector2d(999,-999);

        assertTrue(vector1.precedes(vector2));
        assertTrue(vector2.precedes(vector3));
        assertTrue(vector1.precedes(vector3));
        assertFalse(vector1.precedes(vector4));
    }

    @Test
    void follows() {
        Vector2d vector1 = new Vector2d(1,2);
        Vector2d vector2 = new Vector2d(2,3);
        Vector2d vector3 = new Vector2d(3,3);
        Vector2d vector4 = new Vector2d(999,-999);

        assertTrue(vector2.follows(vector1));
        assertTrue(vector3.follows(vector2));
        assertTrue(vector3.follows(vector1));
        assertFalse(vector3.precedes(vector4));

    }

    @Test
    void add() {
        assertEquals(new Vector2d(10,10), new Vector2d(9,1).add(new Vector2d(1,9)));
    }

    @Test
    void subtract() {
        assertEquals(new Vector2d(3,3), new Vector2d(9,8).subtract(new Vector2d(6,5)));
    }

    @Test
    void upperRight() {
        assertEquals(new Vector2d(6,6), new Vector2d(6,-999).upperRight(new Vector2d(-2321, 6)));
    }

    @Test
    void lowerLeft() {
        assertEquals(new Vector2d(6,6), new Vector2d(6,999).lowerLeft(new Vector2d(2321, 6)));
    }

    @Test
    void opposite() {
        assertEquals(new Vector2d(-8, -7), new Vector2d(8, 7).opposite());
    }

    @Test
    void testEquals() {
        assertEquals(new Vector2d(100, 100), new Vector2d(100, 100));
        assertNotEquals(new Vector2d(0, 0), new Vector2d(0, 1));
    }
}