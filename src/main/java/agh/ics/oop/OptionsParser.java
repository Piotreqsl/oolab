package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {

    public MoveDirection[] parse(String[] args){
        MoveDirection[] res = new MoveDirection[args.length];
        int accepted = 0;
        for(var str : args){
            switch (str){
                case "f":
                case "forward":
                    res[accepted] = MoveDirection.FORWARD;
                    accepted++;
                    break;
                case "b":
                case "backward":
                    res[accepted] = MoveDirection.BACKWARD;
                    accepted++;
                    break;
                case "l":
                case "left":
                    res[accepted] = MoveDirection.LEFT;
                    accepted++;
                    break;
                case "r":
                case "right":
                    res[accepted] = MoveDirection.RIGHT;
                    accepted++;
                    break;
                default:
                    throw new IllegalArgumentException(str + " is not legal move specification");
            }
        }
        return Arrays.copyOfRange(res,0, accepted);
    }
}
