package agh.ics.oop;

import javafx.scene.control.Label;

import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
public class SimulationEngine implements IEngine{

    private MoveDirection[] moveDirections;
    private IWorldMap map;
    private Vector2d[] initials;
    private ArrayList<Animal> animals;

    public SimulationEngine(MoveDirection[] tab, IWorldMap map, Vector2d[] initials){
        this.moveDirections = tab;
        this.map = map;
        this.initials = initials;
        this.animals = new ArrayList<Animal>();

        for(var pos : initials){
            Animal newAnimal = new Animal(map,pos);
            if(map.place(newAnimal))
                animals.add(newAnimal);

        }


    }

    private void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {

        JFrame jFrame = new JFrame();
        JTextArea text = new JTextArea();
        text.setText(map.toString());
        jFrame.add(text);
        jFrame.setSize(300,300);
        jFrame.setVisible(true);
        int numOfAnimals = initials.length;
        int numOfMoves = moveDirections.length;
        int i = 0;
        while (i < numOfMoves){
            animals.get(i%numOfAnimals).move(moveDirections[i]);
            sleep();
            text.setText(map.toString());
            i++;
        }



    }

    public Animal getAnimal(int idx){
        return animals.get(idx);
    }
}
