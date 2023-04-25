package GameLevels;

import Enemies.Beetle;
import Enemies.BeetleEncounter;
import Enemies.Skeleton;
import Enemies.SkeletonEncounter;
import Objects.Coins;
import Objects.CoinsPickup;
import Objects.Platform;
import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import game.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Level2 extends GameLevel {

    private static SoundClip gameMusic;

    static {
        try {
            gameMusic = new SoundClip("data/backgroundMusic.wav");
            gameMusic.loop();
            gameMusic.setVolume(0.1);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public Level2(Game game) {
        super(game);
        gameMusic.play();
        getKnight().setPosition(new Vec2(-34, -13));
        Shape PlatformShape = new BoxShape(3f, 0.5f);
        Shape groundPlatform = new BoxShape(40, 0.5f);

        //Make platforms//
        Platform platform1 = new Platform(this, PlatformShape, -5f,-6.5f, true);
        Platform platform2 = new Platform(this, PlatformShape, -30f,2f, true);
        Platform platform3 = new Platform(this, PlatformShape, -30f,-9f, true);
        Platform platform4 = new Platform(this, PlatformShape, -16f,-2f, true);
        Platform platform5 = new Platform(this, PlatformShape, 30f,-11f, true);
        Platform platform6 = new Platform(this, PlatformShape, 30f,4f, true);
        Platform platform7 = new Platform(this, PlatformShape, 13f,-8f, true);
        Platform platform8 = new Platform(this, PlatformShape, -2f,2f, true);
        Platform platform9 = new Platform(this, PlatformShape, 13f,4f, true);
        Platform platform10 = new Platform(this, PlatformShape, -16,7f, true);
        // Make a ground platform//
        Platform platformG = new Platform(this, groundPlatform, 0f,-15f, 1);

        //Make coins//
        CoinsPickup cp = new CoinsPickup(getKnight(), this, game);
        Coins c1 = new Coins(this);
        c1.setPosition(new Vec2(-25f, -13.7f));
        c1.addCollisionListener(cp);

        Coins c2 = new Coins(this);
        c2.setPosition(new Vec2(6f, -13.7f));
        c2.addCollisionListener(cp);

        Coins c3 = new Coins(this);
        c3.setPosition(new Vec2(13f, -6.7f));
        c3.addCollisionListener(cp);

        Coins c4 = new Coins(this);
        c4.setPosition(new Vec2(-16f, -0.7f));
        c4.addCollisionListener(cp);

        Coins c5 = new Coins(this);
        c5.setPosition(new Vec2(13f, 5.3f));
        c5.addCollisionListener(cp);

        Coins c6 = new Coins(this);
        c6.setPosition(new Vec2(30f, 5.3f));
        c6.addCollisionListener(cp);

        //Make beetles//
        BeetleEncounter be = new BeetleEncounter(getKnight());
        Beetle B1 = new Beetle(this);
        B1.setPosition(new Vec2(15f, -12f));
        B1.addCollisionListener(be);

        Beetle B2 = new Beetle(this);
        B2.setPosition(new Vec2(-10f, -12f));
        B2.addCollisionListener(be);

        Beetle B3 = new Beetle(this);
        B3.setPosition(new Vec2(-6f, -4f));
        B3.addCollisionListener(be);

        Beetle B4 = new Beetle(this);
        B4.setPosition(new Vec2(-1f, 5f));
        B4.addCollisionListener(be);

        Beetle B5 = new Beetle(this);
        B5.setPosition(new Vec2(-30f, -6f));
        B5.addCollisionListener(be);

        Beetle B6 = new Beetle(this);
        B6.setPosition(new Vec2(-16f, 10f));
        B6.addCollisionListener(be);

        Beetle B7 = new Beetle(this);
        B7.setPosition(new Vec2(30f, -8f));
        B7.addCollisionListener(be);

        getKnight().addCollisionListener(be);
        getKnight().addCollisionListener(cp);
    }

    @Override
    public boolean isComplete() {
        if (getKnight().getCoins() == 12)
            return true;
        else return false;
    }

    @Override
    public void endMusicBackground(){
        gameMusic.stop();
    }
}
