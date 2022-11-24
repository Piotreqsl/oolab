package agh.ics.oop;

import java.util.Comparator;

public class V2DComparator implements Comparator<Vector2d> {

    private boolean byX;

    public V2DComparator(boolean byX){
        this.byX = byX;
    }
    @Override
    public int compare(Vector2d v1, Vector2d v2){
        if (byX){
            if (v1.x< v2.x)
                return -1;
            else if (v1.x > v2.x)
                return 1;
            else if (v1.y < v2.y)
                return -1;
            else if (v1.y > v2.y)
                return 1;
        }
        else{
            if (v1.y< v2.y)
                return -1;
            else if (v1.y > v2.y)
                return 1;
            else if (v1.x < v2.x)
                return -1;
            else if (v1.x > v2.x)
                return 1;
        }
        return 0;
    }
}