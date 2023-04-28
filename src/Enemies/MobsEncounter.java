package Enemies;

import GUI.DeathScreen;
import GameLevels.GameLevel;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.GameView;
import game.Knight;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public abstract class MobsEncounter implements CollisionListener {
    private final Knight knight;
    private static SoundClip healthLoss, gameOver;
    private DeathScreen deathScreen;
    private GameLevel level;
    private GameView view;
    private JFrame frame;

    public MobsEncounter(Knight k) {
        knight = k;
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
                level.stop();
                view.removeView();
                frame.add(deathScreen.mainPanel);
                frame.setVisible(true);
            }
        }
    }


}
