package agh.ics.oop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class WorldTest {
    @Test
    public void orentationTest() {
        RectangularMap testMap = new RectangularMap(5,5);
        Animal animal = new Animal(testMap, new Vector2d(2,2));

        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(MapDirection.NORTH, animal.getOrientation());

        animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(MapDirection.EAST, animal.getOrientation());

        animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(MapDirection.SOUTH, animal.getOrientation());

        animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(MapDirection.WEST, animal.getOrientation());

        animal.move(MoveDirection.RIGHT);



        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.RIGHT);

        Assertions.assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    public void movementTest() {
        RectangularMap testMap = new RectangularMap(5,5);
        Animal animal = new Animal(testMap, new Vector2d(2,2));

        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);

        Assertions.assertEquals(new Vector2d(2, 5), animal.getPosition());

        animal.move(MoveDirection.RIGHT);

        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);


        Assertions.assertEquals(new Vector2d(5, 5), animal.getPosition());


        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);

        Assertions.assertEquals(new Vector2d(0, 5), animal.getPosition());



        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);

        Assertions.assertEquals(new Vector2d(0, 1), animal.getPosition());

    }

    @Test
    public void mapEscapeTest() {
        RectangularMap testMap = new RectangularMap(5,5);
        Animal animal = new Animal(testMap, new Vector2d(2,2));
        animal.move(MoveDirection.RIGHT);

        for (int i = 0; i < 20; i++)
            animal.move(MoveDirection.FORWARD);
        Assertions.assertEquals(new Vector2d(5, 2), animal.getPosition());
        animal.move(MoveDirection.LEFT);

        for (int i = 0; i < 20; i++)
            animal.move(MoveDirection.FORWARD);
        Assertions.assertEquals(new Vector2d(5, 5), animal.getPosition());
        animal.move(MoveDirection.LEFT);

        for (int i = 0; i < 20; i++)
            animal.move(MoveDirection.FORWARD);
        Assertions.assertEquals(new Vector2d(0, 5), animal.getPosition());

        animal.move(MoveDirection.LEFT);

        for (int i = 0; i < 20; i++)
            animal.move(MoveDirection.FORWARD);
        Assertions.assertEquals(new Vector2d(0, 0), animal.getPosition());
    }



    @Test
    public void world1Test(){
        String[] testArgs = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(testArgs);
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Assertions.assertEquals(engine.getAnimal(0).getPosition(), new Vector2d(2, 0));
        Assertions.assertEquals(engine.getAnimal(1).getPosition(), new Vector2d(3, 5));

    }

    @Test
    public void world2Test(){
        String[] testArgs = {"f", "r", "r", "f", "f", "f", "f", "f", "f", "l", "l", "l", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(testArgs);
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(0,1) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Assertions.assertEquals(engine.getAnimal(0).getPosition(), new Vector2d(3, 0));
        Assertions.assertEquals(engine.getAnimal(1).getPosition(), new Vector2d(2, 1));
    }
}
