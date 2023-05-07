package Objects;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.Game;
import GameLevels.GameLevel;
import game.Knight;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
/**
 * @author Fathi, Mohamed, Fathi.Mohamed@city.ac.uk
 */
public class CoinsPickup implements CollisionListener {
    private final Knight knight;
    private final GameLevel level;
    private final Game game;
    private static SoundClip coinSound;

    /**
     * constructor used to initialise the knight, game and level
     * @param k used to access the knights class so the coins can be incremented and so the knight collides with the coins as well
     * @param level used to access the level to check if it has passed the criteria of completing the level
     * @param game used to access the game so it can call the next level to be played
     */
    public CoinsPickup(Knight k, GameLevel level, Game game) {
        knight = k;
        this.game = game;
        this.level = level;
    }

    //sound effect when collecting coins
    static{
        try{
            coinSound = new SoundClip("data/coinSound.wav");
            coinSound.setVolume(0.1);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }

    /**
     * method which detects the collision between the player and the coin
     * when the player collides with the coin then the coin count will be incremented by 1 and if the player collect the coins in the requirement then the player will progress to the next level
     * @param collisionEvent used for collision detection
     */
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Coins) {
            knight.addCoins();
            System.out.println(knight.getCoins());
            coinSound.play();
            collisionEvent.getOtherBody().destroy();
            if(level.isComplete()){
                game.goToNextLevel();
            }
        }
    }
}
