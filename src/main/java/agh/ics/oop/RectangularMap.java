package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap{
    public int width;
    public int height;
    private ArrayList<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Vector2d lowerBound = new Vector2d(0,0);
        Vector2d upperBound = new Vector2d(width, height);

        //jeśli wyjeżdzamy poza mapę
        if(position.lowerLeft(lowerBound).equals(lowerBound) == false || position.upperRight(upperBound).equals(upperBound) == false){
            return  false;
        }
        //sprawdzam czy jest jakiś zwierzak

        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        for(var existing: animals){
            if(existing.isAt(animal.getPosition())) return false;
        }
        animals.add(animal);
        return true;

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(var animal: animals){
            if(animal.isAt(position)) return true;
        }

        return false;

    }

    @Override
    public Object objectAt(Vector2d position) {
        for(var animal: animals){
            if(animal.isAt(position)) return animal;
        }

        return null;
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(new Vector2d(0,0), new Vector2d(this.width, this.height));
    }
}
