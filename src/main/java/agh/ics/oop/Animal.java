package agh.ics.oop;




public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection orientation = MapDirection.NORTH;
     IWorldMap map;

    public Animal(){
        this.map = new RectangularMap(4,4);
    }

    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }

    @Override
    public String toString() {
        return orientation.toString();
    }



    public boolean isAt(Vector2d position){
            return this.position.equals(position);
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
                    this.position = allegedNew;
                }
            }
            case BACKWARD -> {
                Vector2d moveDir = this.orientation.toUnitVector();
                Vector2d allegedNew = this.position.subtract(moveDir);
                if(map.canMoveTo(allegedNew)){
                    this.position = allegedNew;
                }
            }


        }
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }
}
