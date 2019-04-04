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
import javafx.scene.layout.Background;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author BastlNoah
 */
public class AnleitungController implements Initializable {

    @FXML
    private Label TxtAnleitung;
    @FXML
    private AnchorPane pane;

    private String text = "Das Ziel des Spiels ist es;\n"
            + "möglichst vielen Hindernissen\n"
            + "auszuweichen und\n"
            + "zu überleben";
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TxtAnleitung.setText(text);
 //        pane.setBackground(new Background(game.images.br));
    }    

    @FXML
    private void handleBtnZurück(ActionEvent event) throws IOException {
        Menu.getApplicationInstance().setScene("Menu.fxml");
    }
    
}
