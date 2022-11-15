package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangularMapTest {

    @Test
    public void canMoveToTest() {
        IWorldMap map = new RectangularMap(2, 2);


        Assertions.assertTrue(map.canMoveTo(new Vector2d(1, 0)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(1, 1)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(1, 2)));
        //Nie można poza mape wyjechac
        Assertions.assertFalse(map.canMoveTo(new Vector2d(1, 3)));
    }

    @Test
    public void placeTest() {
        IWorldMap map = new RectangularMap(2, 2);

        Assertions.assertTrue(map.place(new Animal(map, new Vector2d(1, 1))));
        //Nie można ponownie
        Assertions.assertFalse(map.place(new Animal(map, new Vector2d(1, 1))));
        // Nie można poza mapą
        Assertions.assertFalse(map.place(new Animal(map, new Vector2d(3, 1))));
    }

    @Test
    public void isOccupiedTest() {
        IWorldMap map = new RectangularMap(2, 2);
        Assertions.assertFalse(map.isOccupied(new Vector2d(1, 1)));
        map.place(new Animal(map, new Vector2d(1, 1)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(1, 1)));
    }

    @Test
    public void objectAtTest() {
        IWorldMap map = new RectangularMap(2, 2);
        Assertions.assertNull(map.objectAt(new Vector2d(1, 1)));
        map.place(new Animal(map, new Vector2d(1, 1)));
        Assertions.assertTrue(map.objectAt(new Vector2d(1, 1)) instanceof Animal);
    }
}