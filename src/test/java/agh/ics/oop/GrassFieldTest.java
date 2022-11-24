package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrassFieldTest {


    @Test
    public void canMoveToTest() {
        GrassField map = new GrassField(10);
        Assertions.assertTrue(map.canMoveTo(new Vector2d(1, 0)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(1, 1)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(54, 2)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(1, 5)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1)));
        map.place(new Animal(map, new Vector2d(3, 3)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(3, 3)));
    }

    @Test
    public void placeTest() {
        GrassField map = new GrassField(10);
        Assertions.assertTrue(map.place(new Animal(map, new Vector2d(-1, -1))));
        Assertions.assertTrue(map.place(new Animal(map, new Vector2d(9, 9))));
        //Assertions.assertFalse(map.place(new Animal(map, new Vector2d(9, 9))), "Nie można zduplikować");
        try{
            map.place(new Animal(map, new Vector2d(9, 9)));
            Assertions.fail("Nie można zduplikować");
        }catch(IllegalArgumentException ex){
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void isOccupiedTest() {
        GrassField map = new GrassField(10);
        map.place(new Animal(map, new Vector2d(1, 1)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(1, 1)));
    }

    @Test
    public void objectAtTest() {
        GrassField map = new GrassField(10);
        Assertions.assertTrue(map.objectAt(new Vector2d(1, 1)) == null || map.objectAt(new Vector2d(1, 1)) instanceof Grass);
        map.place(new Animal(map, new Vector2d(1, 1)));
        Assertions.assertTrue(map.objectAt(new Vector2d(1, 1)) instanceof Animal);
    }

    @Test
    public void spawnGrassTest() {
        GrassField map = new GrassField(0);
        Assertions.assertTrue(map.spawnGrassAt(new Vector2d(3, 3)));
        Assertions.assertTrue(map.objectAt(new Vector2d(3, 3)) instanceof Grass);
    }

}