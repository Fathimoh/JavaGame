package game;

import GameLevels.GameLevel;
import GameLevels.Level1;
import GameLevels.Level2;
import GameLevels.Level3;
import city.cs.engine.SoundClip;

import javax.swing.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Your main game entry point
 */
public class Game {
    private GameLevel level;
    private GameView view;
    private KnightController controller;

    /** Initialise a new Game. */
    public Game() {
        level = new Level1(this);

        view = new GameView(level, 1424, 600, level.getKnight());
        controller = new KnightController(level.getKnight());
        view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));

        //create a Java window (frame) and add the game
        final JFrame frame = new JFrame("Journey of the Knight");
        frame.add(view);
        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
        // JFrame debugView = new DebugViewer(world, 500, 500);

        level.start();


        //Use encapsulated gameWorld instead of a normal world//
        //create background sound for the game

        try {
            SoundClip gameMusic = new SoundClip("data/backgroundMusic.wav"); //add sound file here
            gameMusic.loop();
            gameMusic.setVolume(0.1);
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }

        // start our game world simulation!
        //Tracker tracker = new Tracker(view, world.getKnight());
        //world.addStepListener(tracker);
    }

    public void goToNextLevel(){
        if (level instanceof Level1){
            int coins = level.getKnight().getCoins();
            level.stop();
            level = new Level2(this);
            //level now refer to the new level
            view.setWorld(level);
            controller.updateKnight(level.getKnight());
            level.getKnight().setCoins(coins);
            view.updateKnight(level.getKnight()); //
            level.start();
        }

        else if(level instanceof Level2){
            int coins = level.getKnight().getCoins();
            level.stop();
            level = new Level3(this);
            view.setWorld(level);
            controller.updateKnight(level.getKnight());
            level.getKnight().setCoins(coins);
            view.updateKnight(level.getKnight()); //
            level.start();
        }

        else if (level instanceof Level3){
            System.out.println("Well done! Game complete.");
            System.exit(0);
        }
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
