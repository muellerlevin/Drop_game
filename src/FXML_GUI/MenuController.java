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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author BastlNoah
 */
public class MenuController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane pane;
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  //       pane.setBackground(new Background(game.images.br));
        // TODO
    }    

    @FXML
    private void handleBtnExit(ActionEvent event) {
        System.exit(1);
    }

    @FXML
    private void handleBtnAnleitung(ActionEvent event) throws IOException {
          Menu.getApplicationInstance().setScene("Anleitung.fxml");
    }

    @FXML
    private void handleBtnOption(ActionEvent event) throws IOException {
          Menu.getApplicationInstance().setScene("Optionen.fxml");
    }

    @FXML
    private void handleBtnSpielen(ActionEvent event) throws IOException {
        Menu.getApplicationInstance().setScene("Spiel.fxml");
    }

    
    
}
