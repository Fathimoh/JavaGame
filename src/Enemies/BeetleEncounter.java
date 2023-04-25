package Enemies;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.Knight;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class BeetleEncounter implements CollisionListener {
    private final Knight knight;
    private static SoundClip healthLoss, gameOver;

    public BeetleEncounter(Knight k) {
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
