package game;

import city.cs.engine.DebugViewer;

import javax.swing.JFrame;

/**
 * Your main game entry point
 */
public class Game {


    /** Initialise a new Game. */
    public Game() {

        //Use encapsulated gameWorld instead of a normal world//
        GameWorld world = new GameWorld();

        //make a view to look into the game world
        GameView view = new GameView(world, 1424, 600, world.getKnight());
        KnightController kc = new KnightController(world.getKnight());
        view.addKeyListener(kc);

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

        // start our game world simulation!
        world.start();
        GiveFocus focus = new GiveFocus(view);
        view.addMouseListener(focus);

        //Tracker tracker = new Tracker(view, world.getKnight());
        //world.addStepListener(tracker);
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
