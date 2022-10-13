package agh.ics.oop;

import java.util.Map;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;




    @Override
    public String toString() {
        return switch (this) {
            case EAST -> "Wschod";
            case WEST -> "Zachod";
            case SOUTH -> "Poludnie";
            case NORTH -> "Polnoc";
        };
    }

    public MapDirection next() {
        return switch (this){
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            case EAST -> SOUTH;
        };
    }

    public MapDirection previous() {
        return switch (this){
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            case EAST -> NORTH;
        };
    }

    public Vector2d toUnitVector(){
        return switch (this){
            case NORTH -> new Vector2d(0,1);
            case SOUTH -> new Vector2d(0,-1);
            case WEST -> new Vector2d(-1,0);
            case EAST -> new Vector2d(1,0);
        };
    }




}