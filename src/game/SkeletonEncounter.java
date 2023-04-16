package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class SkeletonEncounter implements CollisionListener {

    private final Knight knight;
    private static SoundClip healthLoss, gameOver;
    private GameLevel level;
    private Game game;

    public SkeletonEncounter(Knight k) {
        knight = k;
    }

    static{
        try{
            healthLoss = new SoundClip("data/"); //add sound for losing health
            gameOver = new SoundClip("data/"); //add sound for game over
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }



    //collision between the knight and the skeleton. Colliding with skeleton will make you die//
    @Override
    public void collide(CollisionEvent collisionEvent) {
        //int health = 3;
        if (collisionEvent.getOtherBody() instanceof Knight) {
            knight.DecreaseKnightHealth();
            //healthLoss.play();
            if (knight.getHealth() <= 0) {
                knight.destroy();
                //gameOver.play();
                System.exit(0);
            }
        }
    }
}