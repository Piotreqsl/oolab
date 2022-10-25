package agh.ics.oop;

public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection orientation = MapDirection.NORTH;


    @Override
    public String toString() {
        return "Zwierze :" +
                "pozycja=" + position.toString() +
                ", orientacja=" + orientation.toString();
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public boolean isAt(Vector2d position){
            return this.position.equals(position);
    }

    public void move(MoveDirection direction){
        Vector2d lowerBound = new Vector2d(0,0);
        Vector2d upperBound = new Vector2d(4,4);
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

                if(allegedNew.lowerLeft(lowerBound).equals(lowerBound) && allegedNew.upperRight(upperBound).equals(upperBound)){
                    this.position = allegedNew;
                }
            }
            case BACKWARD -> {
                Vector2d moveDir = this.orientation.toUnitVector();
                Vector2d allegedNew = this.position.subtract(moveDir);

                if(allegedNew.lowerLeft(lowerBound).equals(lowerBound) && allegedNew.upperRight(upperBound).equals(upperBound)){
                    this.position = allegedNew;
                }
            }


        }
    }
}
