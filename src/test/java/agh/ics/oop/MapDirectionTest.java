package agh.ics.oop;

import org.junit.jupiter.api.Test;


import static agh.ics.oop.MapDirection.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MapDirectionTest {

    @Test
    void next() {
        assertEquals(EAST, NORTH.next());
        assertEquals(WEST, SOUTH.next());
        assertEquals(NORTH, WEST.next());
        assertEquals(SOUTH, EAST.next());


    }

    @Test
    void previous() {
        assertEquals(WEST, NORTH.previous());
        assertEquals(EAST, SOUTH.previous());
        assertEquals(SOUTH, WEST.previous());
        assertEquals(NORTH, EAST.previous());
    }
}