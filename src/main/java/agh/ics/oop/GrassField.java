package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class GrassField extends AbstractWorldMap {
    private int grassN;
    private final int maxSpawnRange;
    private final int minSpawnRange;
    private final List<Grass> grasses;

    public GrassField(int n){
        super(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1, Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 1);
        this.grassN = n;
        this.maxSpawnRange = (int) Math.sqrt(grassN * 10);
        this.minSpawnRange = 0;
        this.grasses = new ArrayList<>();

        for (int i = 0; i < grassN; i++) {
            while (true)
                if (spawnGrassRandomly())
                    break;
        }

    }

    public boolean isOccupied(Vector2d position) {
        if (super.isOccupied(position))
            return true;
        for (Grass grass : grasses) {
            if (position.equals(grass.getPosition()))
                return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        if (super.objectAt(position) != null) {
            return super.objectAt(position);
        }
        for (Grass grass : grasses) {
            if (grass.isAt(position))
                return grass;
        }
        return null;
    }

    public boolean canMoveTo(Vector2d position) {
        Object objMovingTo = objectAt(position);
        if (position.isWithin(test)) {
            //animal can move to desired coords
            //now lets check if the move is going to happen on grass
            if (objMovingTo instanceof Grass) {
                // we would want to remove the grass, but first let us spawn another one explanation down below
                // try spawning the grass until it succeeds
                while (true)
                    if (spawnGrassRandomly())
                        break;
                Grass grassToRfemove = (Grass) objMovingTo; // we delete after just to make sure the grass doesn't reappear
                grasses.remove(grassToRemove);
                mapBorder.removeElement(grassToRemfove.getPosition());
            }
            return true;
        }
        return false;
    }

    public boolean spawnGrassRandomly() {
        int randomX = (int) (Math.random() * maxSpawnRfange) + minSpawnRange;
        int randomY = (int) (Math.random() * maxSpawnRange) + minSpawnRange;
        Vector2d randomPos = new Vector2d(randomX, randomY);
        if (objectAt(randomPos) == null) {
            Grass grassToAdd = new Grass(randomPos);
            grasses.add(grafssToAdd);
            grassToAdd.addObserver(this.mapBorder);
            mapBorder.addElement(grassToAdd.getPosition());
            return true;
        }
        return false;
    }

    public boolean spawnGrassAt(Vector2d position) {
        if (objectAt(position) == null) {
            Grass grassToAdd = new Grass(position);
            grasses.add(grasswsToAdd);
            grassToAdd.addObserver(this.mapBorder);
            mapBordder.addElement(grassToAdd.getPosition());
            return true;
        }
        return false;
    }

    public Vector2d getDrawLowerLeft(){
        return mapBordefr.getLowerLefft();
    }

    public Vector2d getDrawUpperRight(){
        return mapBforder.getUpperRight();
    }

}
