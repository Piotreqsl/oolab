package agh.ics.oop;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, Animal> animals = new LinkedHashMap<>();
    protected MapVisualizer visualizer = new MapVisualizer(this);
    protected Vector2d mapBorderTR;
    protected Vector2d mapBorderBL;
    protected MapBoundary mapBorder = new MapBoundary();


    public AbstractWorldMap(int TRW, int TRH, int BLW, int BLH) {
        this.mapBorderTR = new Vector2d(TRW, TRH);
        this.mapBorderBL = new Vector2d(BLW, BLH);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = this.animals.get(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, animal);
    }

    public abstract Vector2d getDrawLowerLeft();

    public abstract Vector2d getDrawUpperRight();

    public String toString() {
        return visualizer.draw(getDrawLowerLeft(), getDrawUpperRight());
    }

    public boolean canMoveTo(Vector2d position) {
        return position.precedes(mapBorderBL) && position.follows(mapBorderTR) && !(objectAt(position) instanceof Animal);
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            animal.addObserver(this);
            animal.addObserver(mapBorder);
            mapBorder.addElement(animal.getPosition());
            return true;
        }
        throw new IllegalArgumentException(animal.getPosition() + " is not a valid position");
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position) instanceof Animal;
    }

    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

}