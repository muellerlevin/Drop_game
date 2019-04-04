/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML_GUI;

import game.Steuerung;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author BastlNoah
 */
public class VerlorenController implements Initializable {

    @FXML
    public Text punktzahl;
    @FXML
    private AnchorPane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        punktzahl.setText("Score: " + Steuerung.score);
  //      pane.setBackground(new Background(game.images.br));
 
    }

    @FXML
    private void handleBtnSpielen(ActionEvent event) throws IOException {
        Menu.getApplicationInstance().setScene("Spiel.fxml");
    }

    @FXML
    private void handleBtnZurück(ActionEvent event) throws IOException {
        Menu.getApplicationInstance().setScene("Menu.fxml");
    }

}
