package FXML_GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author BastlNoah
 */
public class Menu extends Application {

    private static Menu application;
    private Stage stage = null;

    @Override
    public void start(Stage stage) throws Exception {
        application = this;
        this.stage = stage;

        setScene("Menu.fxml");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void setScene(String menufxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(menufxml));

        Scene scene = new Scene(root);

        scene.getStylesheets().add((getClass().getResource("style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.setTitle("Drob Game");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/Star.png")));
    }

    public static Menu getApplicationInstance() {
        return application;
    }

}
