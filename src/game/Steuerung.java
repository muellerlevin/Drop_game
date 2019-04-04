/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import FXML_GUI.Menu;
import FXML_GUI.SpielController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Steuerung {

    int max = 10;
    public Timer timer = null;
    public Hindernis[] Hindernisse = new Hindernis[max];
    private int laengeHindernisse = 0;
    public PlayerObject player = new PlayerObject();
    public SpielController control;
    public static double spielerspeed = 3;
    public double speed;
    public static double hindernisGeschwindigkeit = 3;
    public double hspeed;
    public static long score = 0;
    private int zaehler = 0;
    public boolean pause;

    public Steuerung(SpielController spiel) {
        this.control = spiel;
        speed = spielerspeed;
        hspeed = hindernisGeschwindigkeit;
        score = 0;

        erzeugeHindernisse();
        control.pane.getChildren().add(player);
        if (timer == null) {
            timer = new Timer(this);
            control.pane.setOnKeyPressed(timer);
        }
        timer.start();
        pause = false;
    }

    public void erzeugeHindernisse() {
        System.out.println(laengeHindernisse);
        if (laengeHindernisse < max) {

            Hindernisse[laengeHindernisse] = new Hindernis(control.pane);
            if (laengeHindernisse == 0) {
                Hindernisse[laengeHindernisse].setY(700 + Hindernisse[laengeHindernisse].getFitHeight());//700 da höhe vom Pane noch nicht übergeben wurde, warum auch immer
                Hindernisse[laengeHindernisse].setX(Math.random() * 500 + 1 + Hindernisse[laengeHindernisse].getFitHeight());
            } else {

                Hindernisse[laengeHindernisse].setY(control.pane.getHeight() + Hindernisse[laengeHindernisse - 1].getY() / 1.5 + Hindernisse[laengeHindernisse].getFitHeight());
            }
            control.pane.getChildren().add(Hindernisse[laengeHindernisse]);
            laengeHindernisse++;

        }
    }

    public void bewegen(boolean hoch, boolean runter, boolean links, boolean rechts) {
        for (int i = 0; i < laengeHindernisse; i++) {
            Hindernisse[i].setY(Hindernisse[i].getY() - hspeed);
            if (Hindernisse[i].getY() + 2 * Hindernisse[i].getFitHeight() <= 0) {
                erzeugeHindernisse();
                Hindernisse[i].setY(control.pane.getHeight() + Hindernisse[i].getFitHeight());
                double x = (Math.random() * control.pane.getWidth() + 1);
                if (x > control.pane.getWidth() - Hindernisse[i].getFitWidth()) {
                    x -= Hindernisse[i].getFitWidth();
                }
                Hindernisse[i].setX(x);
            }

        }

        zaehler++;
        if (zaehler >= 25) {
            score++;
            zaehler = 0;
            control.score.setText("Score: " + String.valueOf(score));
            if (score % 50 == 0 && score != 0) {
                hspeed++;
                speed++;

            }
        }

        try {
            treffer();
        } catch (IOException ex) {
            Logger.getLogger(Steuerung.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (hoch) {
            if (player.getY() <= 0) {
                hoch = false;
            } else {
                player.setY(player.getY() - speed);
            }
        }
        if (runter) {
            if (player.getY() + player.getFitHeight() >= control.pane.getHeight()) {
                runter = false;
            } else {
                player.setY(player.getY() + speed);
            }
        }
        if (rechts) {
            if (player.getX() + player.getFitWidth() >= control.pane.getWidth()) {
                rechts = false;
            } else {
                player.setX(player.getX() + speed);
            }
        }
        if (links) {
            if (player.getX() <= 0) {
                links = false;
            } else {
                player.setX(player.getX() - speed);
            }
        }
    }

    public void treffer() throws IOException {
        for (int i = 0; i < laengeHindernisse; i++) {
            if (Hindernisse[i].intersects(player.getX(), player.getY(), player.getFitWidth(), player.getFitHeight())) {
                timer.stop();
                Menu.getApplicationInstance().setScene("Verloren.fxml");
            }
        }
    }

    public void pause() {
        if (pause == false) {
            timer.stop();
            pause = true;
            control.txtpause.setVisible(true);
        } else {
            timer.start();
            pause = false;
            control.txtpause.setVisible(false);
        }
    }

}
