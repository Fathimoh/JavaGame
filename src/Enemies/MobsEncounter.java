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
