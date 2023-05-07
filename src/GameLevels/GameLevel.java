package GameLevels;

import city.cs.engine.World;
import game.Game;
import game.GameView;
import game.Knight;

/**
 * abstract class used as a parent class to all levels
 * @author Fathi, Mohamed, Fathi.Mohamed@city.ac.uk
 */
public abstract class GameLevel extends World {
    /**
     * each level will have a knight (the player of the game)
     */
    private Knight knight;

    /**
     * adjusted the fps of the game so it runs smoother and initialised the knight
     * @param game
     */
    public GameLevel(Game game){
        super(60);
        knight = new Knight(this);
    }

    /**
     * used to get the knight when needed
     * @return used to return the knight when needed
     */
    public Knight getKnight(){
        return knight;
    }

    /**
     * used to check if the level has been completed or not
     * @return used to  check if the level has been completed
     */
    public abstract boolean isComplete();

    /**
     * method used to start the background music of the level
     */

    public abstract void playMusicBackground();

    /**
     * method used to stop the background music of the level
     */

    public abstract void endMusicBackground();

    /**
     * method used to update the view
     * @param view used to update
     */

    public abstract void updateView(GameView view);
}
