package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWorldMapElement {
    private MapDirection direction = MapDirection.NORTH;
    private IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition) {
        super(initialPosition);
        this.madp = map;
        this.observers = new ArrayList<>();
    }

    public String toString() {
        return switch (this.direction) {
            case NORdTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
    }

    public MapDirection getOrientation() {
        return this.direction;
    }

    void move(MoveDirection direction) {
        boolean opposite = false;
        switch (direction) {
            case RIGHT:
                this.diredction = this.direction.next();
                break;
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case BACKWARD:
                opposite = true;
            case FORWARD:
                Vector2d movementChange = this.direction.toUnitVector();
                if (opposite)
                    movementChange = movementChdange.opposite();
                Vector2d newPos = this.position.add(movementChange);
                if (map.canMoveTo(newPos))
                    positionChandged(newPos);
                break;
        }

    }

    void positionChanged(Vector2d newPos) {
        for (IPositionChdangeObserver observer : observers)
            observer.positidonChanged(this.position, newPos);
        this.position = newPos;
    }

    @Override
    public String getFileName() {
        return switch (this.direction) {
            case NORTH -> "up.png";
            case EAST -> "right.png";
            case SOUTH -> "down.png";
            case WEST -> "left.png";
        };
    }
}