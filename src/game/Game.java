package game;

import GUI.ControlPanel;
import GUI.DeathScreen;
import GameLevels.GameLevel;
import GameLevels.Level1;
import GameLevels.Level2;
import GameLevels.Level3;

import javax.swing.*;
import java.awt.*;

/**
 * Your main game entry point
 */
public class Game {
    private GameLevel level;
    private final GameView view;
    private final KnightController controller;
    private final ControlPanel controlPanel;
    private final DeathScreen deathScreen;
    private final JFrame frame;

    /** Initialise a new Game. */
    public Game() {
        level = new Level1(this);
        view = new GameView(level, 1424, 600, level.getKnight());
        controller = new KnightController(level.getKnight());
        view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));

        //create a Java window (frame) and add the game
        frame = new JFrame("Journey of the Knight");
        //frame.add(view);
        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setSize(new Dimension(1424, 650));
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        //frame.pack();
        // finally, make the frame visible

        deathScreen = new DeathScreen(frame, level, view, this);
        controlPanel = new ControlPanel(frame, level, view);
        frame.add(controlPanel.mainPanel);

        frame.setVisible(true);

    }

    public void goToNextLevel(){
        if (level instanceof Level1){
            int coins = level.getKnight().getCoins();
            level.stop();
            level.endMusicBackground();
            //then repeat for all levels
            level = new Level2(this);
            controlPanel.updateLevel(level);
            deathScreen.updateLevel(level);
            //level now refer to the new level
            view.setWorld(level);
            view.update(level);
            controller.updateKnight(level.getKnight());
            level.getKnight().setCoins(coins);
            view.updateKnight(level.getKnight());
            level.start();
        }

        else if(level instanceof Level2){
            int coins = level.getKnight().getCoins();
            level.stop();
            level.endMusicBackground();
            level = new Level3(this);
            controlPanel.updateLevel(level);
            deathScreen.updateLevel(level);
            view.setWorld(level);
            view.update(level);
            controller.updateKnight(level.getKnight());
            level.getKnight().setCoins(coins);
            view.updateKnight(level.getKnight());
            level.start();
        }

        else if (level instanceof Level3){
            level.stop();
            view.removeView();
            frame.add(deathScreen.mainPanel);
            frame.setVisible(true);
            level.endMusicBackground();

        }
    }
    public void restartLevel(){
        level = new Level1(this);
        controlPanel.updateLevel(level);
        deathScreen.updateLevel(level);
        view.setWorld(level);
        view.update(level);
        controller.updateKnight(level.getKnight());
        view.updateKnight(level.getKnight());
        level.start();
        level.playMusicBackground();
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
}
