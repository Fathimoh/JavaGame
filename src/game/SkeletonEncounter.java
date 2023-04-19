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

    public SkeletonEncounter(Knight k) {
        knight = k;
    }

    static{
        try{
            healthLoss = new SoundClip("data/healthLoss.wav");
            healthLoss.setVolume(0.12);
            gameOver = new SoundClip("data/gameOver.wav");
            gameOver.setVolume(0.2);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e);
      }

    }




    //collision between the knight and the skeleton. Colliding with skeleton will make you die//
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Knight) {
            knight.DecreaseKnightHealth();
            healthLoss.play();
            if (knight.getHealth() <= 0) {
                knight.destroy();
                gameOver.play();
            }
        }
    }
}