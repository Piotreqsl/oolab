package agh.ics.oop;

import javafx.scene.control.Label;

import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
public class SimulationEngine implements IEngine{

    private MoveDirection[] moveDirections;
    private RectangularMap map;
    private Vector2d[] initials;
    private ArrayList<Animal> animals;

    public SimulationEngine(MoveDirection[] tab, RectangularMap map, Vector2d[] initials){
        this.moveDirections = tab;
        this.map = map;
        this.initials = initials;
        this.animals = new ArrayList<Animal>();

        for(var pos : initials){
            Animal newAnimal = new Animal(map,pos);
            if( map.place(newAnimal))
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
        MapVisualizer mapVisualizer = new MapVisualizer(this.map);
        Vector2d lower = new Vector2d(0,0);
        Vector2d upper = new Vector2d(map.width, map.height);
        JFrame jFrame = new JFrame();
        JTextArea text = new JTextArea();
        text.setText(mapVisualizer.draw(lower, upper));



        jFrame.add(text);
        jFrame.setSize(500,500);
        jFrame.show();
        int numOfAnimals = initials.length;
        int numOfMoves = moveDirections.length;
        int i = 0;
        while (i < numOfMoves){
            animals.get(i%numOfAnimals).move(moveDirections[i]);
            sleep();
            //System.out.println(animals.get(0));
            text.setText(mapVisualizer.draw(lower, upper));
            i++;
        }


    }

    public Animal getAnimal(int idx){
        return animals.get(idx);
    }
}
