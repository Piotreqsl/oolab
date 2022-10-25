package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalIntegrationTest {

    @Test
    public void directionTest(){
        Animal animal = new Animal();

        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH, animal.getOrientation());

        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, animal.getOrientation());
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.SOUTH, animal.getOrientation());
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.WEST, animal.getOrientation());

    }

    @Test
    public void movementTest(){
        Animal animal = new Animal();

        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);

        assertEquals(true,animal.isAt(new Vector2d(2,4)));

        animal.move(MoveDirection.LEFT);

        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);


        assertEquals(true,animal.isAt(new Vector2d(0,4)));


        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);

        assertEquals(true,animal.isAt(new Vector2d(4,4)));

        animal.move(MoveDirection.LEFT);

        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);

        assertEquals(true,animal.isAt(new Vector2d(4,0)));
        assertEquals(false,animal.isAt(new Vector2d(4,4)));

    }

    @Test
    public void parserTest() {
        OptionsParser parser = new OptionsParser();


        String[] test_args = {"f", "blad", "forward", "INV"};
        MoveDirection[] expected = {MoveDirection.FORWARD, MoveDirection.FORWARD};
        assertArrayEquals(expected, parser.parse(test_args));



        String[] test_args2 = {"f", "b", "r", "l", "forward", "backward", "right", "left"};
        MoveDirection[] expected1 = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT,
                MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.RIGHT, MoveDirection.LEFT};
        assertArrayEquals(expected1, parser.parse(test_args2));


        String[] test_args3 = {"testowe", "losowe", "argumenty"};
        MoveDirection[] expected2 = {};
        assertArrayEquals(expected2, parser.parse(test_args3));


    }

}
