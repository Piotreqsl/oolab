package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {


    Comparator<Vector2d> comparatorX = new V2DComparator(true);
    Comparator<Vector2d> comparatorY = new V2DComparator(false);
    SortedSet<Vector2d> sortedSetX = new TreeSet<>(comparatorX);
    SortedSet<Vector2d> sortedSetY = new TreeSet<>(comparatorY);

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        removeElement(oldPosition);
        addElement(newPosition);
    }

    public void addElement(Vector2d element){
        sortedSetX.add(element);
        sortedSetY.add(element);
    }

    public void removeElement(Vector2d element){
        sortedSetY.remove(element);
        sortedSetX.remove(element);
    }

    public Vector2d getLowerLeft(){
        return new Vector2d(sortedSetX.first().x,sortedSetY.first().y);
    }

    public Vector2d getUpperRight(){
        return new Vector2d(sortedSetX.last().x, sortedSetY.last().y);
    }

}