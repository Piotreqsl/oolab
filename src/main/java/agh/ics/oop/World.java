package agh.ics.oop;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
public class World {



    public static void run(){
        System.out.println("Zwierzak idze do przodu");
    }

    // ZAD 11
//    public static void run(String[] arguments){
//        int len = arguments.length;
//        for(String argument : arguments){
//            if(argument.equals(arguments[len-1])){
//                System.out.print(argument);
//            }
//            else{
//                System.out.print(argument + ", ");
//            }
//        }
//        System.out.println(""); //pusta linijka
//    }

    public static void run(String[] arguments){

        for(String argument : arguments){
            switch (argument) {
                case "f":
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case "b":
                    System.out.println("Zwierzak idzie do tylu");
                    break;
                case "r":
                    System.out.println("Zwierzak skreca w prawo");
                    break;
                case "l":
                    System.out.println("Zwierzak skreca w lewo");
                    break;
                default:
                    //System.out.println("Nienzana komenda " + arg);

            }
        }

    }




    public static void run(Direction[] dirs){
        for(Direction dir: dirs){
            switch(dir) {
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak skręca w prawo");
                    break;
                case LEFT:
                    System.out.println("Zwierzak skręca w lewo");
                    break;
            }}

    }
    public static Direction[] convert(String[] args){
        Direction[] dirs = new Direction[args.length];
        int acceptedItems = 0;

        for(String arg: args) {

            switch (arg) {
                case "f":
                    dirs[acceptedItems] = Direction.FORWARD;
                    acceptedItems++;
                    break;
                case "b":
                    dirs[acceptedItems] = Direction.BACKWARD;
                    acceptedItems++;
                    break;
                case "r":
                    dirs[acceptedItems] = Direction.RIGHT;
                    acceptedItems++;
                    break;
                case "l":
                    dirs[acceptedItems] = Direction.LEFT;
                    acceptedItems++;
                    break;
                default:
                    //System.out.println("Nienzana komenda " + arg);

            }

        }
        return Arrays.copyOfRange(dirs, 0, acceptedItems);
    }


    public static  void runStream(List<Direction> dirs){
        dirs.stream().map(dir -> switch(dir) {
            case FORWARD ->  "Zwierzak idzie do przodu";
            case BACKWARD -> "Zwierzak idzie do tylu";
            case RIGHT ->  "Zwierzak skreca w prawo";
            case LEFT ->  "Zwierzak skreca w lewo";
            default -> "NIEROZPOZNANE POLECENIE";

        }).forEach(System.out::println);
    }
    public static List<Direction> convertStream(String[] args){
        List<String> list = Arrays.asList(args);
        List<String> accepted = Arrays.asList("f", "b", "r", "l");

        List<Direction> dirs =  list.stream().filter(accepted::contains).map(e -> switch (e) {
                case "f" ->  Direction.FORWARD;
                case "b" ->  Direction.BACKWARD;
                case "r" ->  Direction.RIGHT;
                case "l" ->  Direction.LEFT;
            default -> Direction.NO_MATCH;
        }).collect(Collectors.toList());



       return  dirs;
    }





    public static void main(String[] args) {
        System.out.println("System wystartował!");


        MoveDirection[] directions = new OptionsParser().parse(args);
        RectangularMap map = new RectangularMap(5, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        System.out.println("System zakończył działanie!");
    }


}
