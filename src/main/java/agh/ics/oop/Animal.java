package agh.ics.oop;


import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWorldMapElement {

    private MapDirection orientation = MapDirection.NORTH;
    private List<IPositionChangeObserver> observers;
     IWorldMap map;

    public Animal(){
        super(new Vector2d(2,2));
        this.map = new RectangularMap(4,4);
    }

    public Animal(IWorldMap map){
        super(new Vector2d(2,2));
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        super(initialPosition);
        this.map = map;
        this.observers = new ArrayList<>();
    }

    @Override
    public String toString() {
        return orientation.toString();
    }





    public void move(MoveDirection direction){
        switch (direction){
            case LEFT -> {
                this.orientation = this.orientation.previous();
            }
            case RIGHT -> {
                this.orientation = this.orientation.next();
            }
            case FORWARD -> {
                Vector2d moveDir = this.orientation.toUnitVector();
                Vector2d allegedNew = this.position.add(moveDir);
                if(map.canMoveTo(allegedNew)){
                    positionChanged(allegedNew);
                }
            }
            case BACKWARD -> {
                Vector2d moveDir = this.orientation.toUnitVector();
                Vector2d allegedNew = this.position.subtract(moveDir);
                if(map.canMoveTo(allegedNew)){

                    positionChanged(allegedNew);
                }
            }
        }
    }

    void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        this.observers.remove(observer);
    }

    void positionChanged(Vector2d newPos) {
        for (IPositionChangeObserver observer : observers)
            observer.positionChanged(this.position, newPos);
        this.position = newPos;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }
}
