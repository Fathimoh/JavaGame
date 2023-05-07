package Enemies;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.Game;
import game.Knight;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public abstract class MobsEncounter implements CollisionListener {
    private final Knight knight;
    private static SoundClip healthLoss, gameOver;
    private Game game;

    /**
     * @author Fathi, Mohamed, Fathi.Mohamed@city.ac.uk
     * @param k
     * @param game
     */

    public MobsEncounter(Knight k, Game game) {
        knight = k;
        this.game = game;
    }

    static {
        try {
            healthLoss = new SoundClip("data/healthLoss.wav");
            healthLoss.setVolume(0.12);
            gameOver = new SoundClip("data/gameOver.wav");
            gameOver.setVolume(0.2);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     *this method displays the deathscreen menu when the knights health is 0. The decreaseknighthealth method is used to decrement the health by 1
     * @param collisionEvent is a collision detection method which checks the players health when it has collided with an enemy
     */

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Knight) {
            knight.DecreaseKnightHealth();
            healthLoss.play();
            if (knight.getHealth() <= 0) {
                knight.destroy();
                gameOver.play();
                game.deathScreen();

            }
        }
    }
}
