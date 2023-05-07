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
 * @author Fathi, Mohamed, Fathi.Mohamed@city.ac.uk
 * Your main game entry point
 */
public class Game {
    /**
     * used to check what level it is
     */
    private GameLevel level;
    /**
     * used to display the game
     */
    private GameView view;
    /**
     * used to control the character
     */
    private KnightController controller;
    /**
     * used to display the main menu
     */
    private final ControlPanel controlPanel;
    /**
     * used to display the death screen
     */
    private final DeathScreen deathScreen;
    /**
     * used to display the frame of the game
     */
    private final JFrame frame;

    /** Initialise a new Game. */
    /**
     * this constructor will initialise a new game
     */
    public Game() {
        level = new Level1(this);
        view = new GameView(level, 1424, 600, level.getKnight());
        controller = new KnightController(level.getKnight());
        view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));

        frame = new JFrame("The Knight's Adventure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setSize(new Dimension(1424, 640));
        frame.setResizable(false);
        deathScreen = new DeathScreen(frame, level, view, this);
        controlPanel = new ControlPanel(frame, level, view);
        frame.add(controlPanel.mainPanel);
        frame.setVisible(true);
    }

    /**
     * method used to switch between levels
     * this method will end the current level then move on to the next level and when doing this many other classes are being updated along
     */
    public void goToNextLevel(){
        if (level instanceof Level1){
            int coins = level.getKnight().getCoins();
            level.stop();
            level.endMusicBackground();
            level = new Level2(this);
            controlPanel.updateLevel(level);
            deathScreen.updateLevel(level);
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
            view.setVisible(false);
            frame.add(deathScreen.mainPanel);
            frame.setVisible(true);
            level.endMusicBackground();

        }
    }

    /**
     * method used to restart the level when you click play again on the deathscreen
     * this method will restart the game from level 1
     */
    public void restartLevel(){
        level.stop();
        level.endMusicBackground();
        level = new Level1(this);
        controlPanel.updateLevel(level);
        deathScreen.updateLevel(level);
        view.setWorld(level);
        view.update(level);
        controller.updateKnight(level.getKnight());
        view.updateKnight(level.getKnight());
        level.start();
    }

    /**
     * method used to display the deathscreen
     * when the knight dies the deathscreen will be brought up with this method
     */
    public void deathScreen(){
        level.endMusicBackground();
        view.setVisible(false);
        deathScreen.mainPanel.setVisible(true);
        frame.add(deathScreen.mainPanel);
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
}
