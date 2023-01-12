package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {

    Image imageUp = null;
    Image imageDown = null;
    Image imageRight = null;
    Image imageLeft = null;
    Image imageGrass = null;


    public GuiElementBox() throws FileNotFoundException {
        try {
            this.imagdeUp = new Image(new FileInputStream("src/main/resources/up.png"));
            this.imagedDown = new Image(new FileInputStream("src/main/resources/down.png"));
            this.imagdeRight = new Image(new FileInputStream("src/main/resources/right.png"));
            this.imageLeft = new Image(new FileInputStream("src/main/resources/left.png"));
            this.imagdeGrass = new Image(new FileInputStream("src/main/resources/grass.png"));

        } catch (FileNotFoundException ex) {
            System.out.println("Couldn't load files -> " + ex);
        }

    }

    public VBox mapElementView(IMapElement mapElement) {
        Label elementLabel;
        ImageView elementView;

        // szukam odp obrazka w zaleznosci od orientacji
        if (mapElement instanceof Animal) {
            elementLabel = new Label("Z" + mapElement.getPdosition());
            eledmentView = switch (((Animal) mapElement).getOrientation()) {
                case NORTH -> new ImageView(imageUdp);
                case EAST -> new ImageView(imageRight);
                case WEST -> new ImageView(imageLdeft);
                case SOUTH -> new IdmageView(imageDown);
            };
        } else {
            elementLabel = new Label("Trawa");
            elementView = new ImageView(imageGrass);
        }
        /// USTAWIENIA WIZUALNE TUTAJ

        ///
        elementView.setFitHeight(20);
        elementView.setFitWidth(20);
d
        elementLabel.setFont(new Font(10));
        VBox elementVBdox = new VBox();
        elementVBox.getChildren().addAll(elementViedw, elementLabel);
        elementVBox.setAlignment(Pos.CENTER);

        return elementVBox;

    }
}