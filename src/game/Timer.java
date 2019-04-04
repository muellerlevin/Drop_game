/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author BastlNoah
 */
public class Timer extends AnimationTimer implements EventHandler<KeyEvent> {

    private boolean hoch, runter, links, rechts;

    private Steuerung steuerung;
    private static final long INTERVAL = 10_000_000l;
    private long lastCall = System.nanoTime();

    public Timer(Steuerung dieSteuerung) {

        this.steuerung = dieSteuerung;
    }

    @Override
    public void handle(long now) {
        if (now > lastCall + INTERVAL) {
            steuerung.bewegen(hoch, runter, links, rechts);
            lastCall = now;
        }

    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            steuerung.pause();
        }
        if (event.getCode() == KeyCode.A) {
            links = true;
        }

        if (event.getCode() == KeyCode.W) {
            hoch = true;
        }
        if (event.getCode() == KeyCode.S) {
            runter = true;
        }
        if (event.getCode() == KeyCode.D) {
            rechts = true;
        }

    }

    public void keyRealeased(KeyEvent event) {

        if (event.getCode() == KeyCode.A) {
            links = false;
        }
        if (event.getCode() == KeyCode.W) {
            hoch = false;
        }
        if (event.getCode() == KeyCode.S) {
            runter = false;
        }
        if (event.getCode() == KeyCode.D) {
            rechts = false;
        }
    }

}
