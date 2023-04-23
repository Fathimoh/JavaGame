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

public class CoinsPickup implements CollisionListener {
    private final Knight knight;
    private final GameLevel level;
    private final Game game;
    private static SoundClip coinSound;

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

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Coins) {
            knight.addCoins();
            System.out.println(knight.getCoins());
            coinSound.play();
            collisionEvent.getOtherBody().destroy();
            if(level.isComplete()){
                game.goToNextLevel();//
            }
        }
    }
}
