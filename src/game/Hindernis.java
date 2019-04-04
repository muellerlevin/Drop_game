/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Administrator
 */
public class Hindernis extends ImageView {

    private final double WIDTH = 50;
    private final double HEIGHT = 50;

    public Hindernis(AnchorPane pane) {

        super.setImage(new Image("/images/Star.png", true));
        double x = (Math.random() * pane.getWidth() + 1);
        if (x > pane.getWidth() - WIDTH) {
            x -= WIDTH;
        }
        super.setX(x);
        super.setFitWidth(WIDTH);
        super.setFitHeight(HEIGHT);
    }

}
