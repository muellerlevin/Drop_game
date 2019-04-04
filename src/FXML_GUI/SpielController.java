package FXML_GUI;

import game.Steuerung;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.text.Text;

public class SpielController implements Initializable {

    @FXML
    public AnchorPane pane;
    public Text score;
    private game.Steuerung dieSteuerung;
    @FXML
    public Button pause;

    @FXML
    public Label txtpause;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtpause.setVisible(false);
        dieSteuerung = new Steuerung(this);
             //pane.setBackground(new Background(game.Images.br));
    }

    @FXML
    private void keyPressed(KeyEvent event) {

    }

    @FXML
    private void keyRealeased(KeyEvent event) {
        dieSteuerung.timer.keyRealeased(event);
    }

    @FXML
    private void pauseBT(ActionEvent event) {
        dieSteuerung.pause();
    }

}
