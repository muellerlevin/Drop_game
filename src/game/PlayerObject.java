package game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayerObject extends ImageView {

    private final double WIDTH = 50;
    private final double HEIGHT = 50;
    private double x = 300;
    private double y = 100;
   

    public PlayerObject() {
        super.setImage(Images.star);
        super.setX(x);
        super.setY(y);
        super.setFitWidth(WIDTH);
        super.setFitHeight(HEIGHT);

    }


}
