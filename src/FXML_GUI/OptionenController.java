package FXML_GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;

/**
 * FXML Controller class
 *
 * @author BastlNoah
 */
public class OptionenController implements Initializable {

    @FXML
    private CheckBox CheckBoxMusik;
    @FXML
    private MenuButton Schwierigkeit;
    @FXML
    private AnchorPane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 //       pane.setBackground(new Background(game.images.br));

    }

    @FXML
    private void handleBtnZurueck(ActionEvent event) throws IOException {
        Menu.getApplicationInstance().setScene("Menu.fxml");
    }

    @FXML
    private void leicht(ActionEvent event) {
        Schwierigkeit.setText("Leicht");
        game.Steuerung.hindernisGeschwindigkeit = 3;
        game.Steuerung.spielerspeed = 8;
    }

    @FXML
    private void normal(ActionEvent event) {
        Schwierigkeit.setText("Normal");
        game.Steuerung.hindernisGeschwindigkeit = 5;
        game.Steuerung.spielerspeed = 5;
    }

    @FXML
    private void schwer(ActionEvent event) {
        Schwierigkeit.setText("Schwer");
        game.Steuerung.hindernisGeschwindigkeit = 8;
        game.Steuerung.spielerspeed = 8;
    }

}
