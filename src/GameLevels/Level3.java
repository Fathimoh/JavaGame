package GameLevels;

import Enemies.Vulture;
import Enemies.VultureEncounter;
import Objects.Coins;
import Objects.CoinsPickup;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import game.Game;
import Objects.Platform;
import org.jbox2d.common.Vec2;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Level3 extends GameLevel {

    private static SoundClip gameMusic;

    static {
        try {
            gameMusic = new SoundClip("data/field_theme_2.wav");
            gameMusic.setVolume(1);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public Level3(Game game) {
        super(game);
        gameMusic.play();
        getKnight().setPosition(new Vec2(-34, -13));
        Shape PlatformShape = new BoxShape(3f, 0.5f);
        Shape groundPlatform = new BoxShape(40, 0.5f);

        //make platforms//
        new Platform(this, PlatformShape, -24f,-11f, 1.1f);

        new Platform(this, PlatformShape, -8.5f,-7f, 1.1f);
        new Platform(this, PlatformShape, -14f,-7f, 1.1f);
        new Platform(this, PlatformShape, -3f,-7f, 1.1f);
        new Platform(this, PlatformShape, 2f,-7f, 1.1f);
        new Platform(this, PlatformShape, 7f,-7f, 1.1f);
        new Platform(this, PlatformShape, 12f,-7f, 1.1f);
        new Platform(this, PlatformShape, 17f,-7f, 1.1f);
        new Platform(this, PlatformShape, 22f,-7f, 1.1f);

        new Platform(this, PlatformShape, 29f,-3f, 1.1f);
        new Platform(this, PlatformShape, 36f,1f, 1.1f);

        new Platform(this, PlatformShape, 22f,2.5f, 1.1f);
        new Platform(this, PlatformShape, 17f,2.5f, 1.1f);
        new Platform(this, PlatformShape, 12f,2.5f, 1.1f);
        new Platform(this, PlatformShape, 7f,2.5f, 1.1f);
        new Platform(this, PlatformShape, 2f,2.5f, 1.1f);
        new Platform(this, PlatformShape, -3f,2.5f, 1.1f);
        new Platform(this, PlatformShape, -8.5f,2.5f, 1.1f);
        new Platform(this, PlatformShape, -14f,2.5f, 1.1f);

        new Platform(this, PlatformShape, -24f,7f, 1.1f);
        new Platform(this, PlatformShape, -30f,-4f, 1.1f);


        //make ground platform//
        new Platform(this, groundPlatform, 0f,-15f, 'b');

        //make coins//
        CoinsPickup cp = new CoinsPickup(getKnight(), this, game);
        Coins c1 = new Coins(this);
        c1.setPosition(new Vec2(-13f, -6f));
        c1.addCollisionListener(cp);

        Coins c2 = new Coins(this);
        c2.setPosition(new Vec2(20f, -6f));
        c2.addCollisionListener(cp);

        Coins c3 = new Coins(this);
        c3.setPosition(new Vec2(-13f, 3.7f));
        c3.addCollisionListener(cp);

        Coins c4 = new Coins(this);
        c4.setPosition(new Vec2(20f, 3.7f));
        c4.addCollisionListener(cp);

        Coins c5 = new Coins(this);
        c5.setPosition(new Vec2(31f, -13.7f));
        c1.addCollisionListener(cp);

        Coins c6 = new Coins(this);
        c6.setPosition(new Vec2(-30f, -2.7f));
        c6.addCollisionListener(cp);

        //make Vultures//
        VultureEncounter ve = new VultureEncounter(getKnight());
        Vulture v1 = new Vulture(this);
        v1.setPosition(new Vec2(25f, -12f));
        v1.addCollisionListener(ve);

        Vulture v2 = new Vulture(this);
        v2.setPosition(new Vec2(-5f, -12f));
        v2.addCollisionListener(ve);

        Vulture v3 = new Vulture(this);
        v3.setPosition(new Vec2(-6f, -4f));
        v3.addCollisionListener(ve);

        Vulture v4 = new Vulture(this);
        v4.setPosition(new Vec2(14f, -4f));
        v4.addCollisionListener(ve);

        Vulture v5 = new Vulture(this);
        v5.setPosition(new Vec2(14f, 5f));
        v5.addCollisionListener(ve);

        Vulture v6 = new Vulture(this);
        v6.setPosition(new Vec2(-6f, 5f));
        v6.addCollisionListener(ve);

        Vulture v7 = new Vulture(this);
        v7.setPosition(new Vec2(11f, -12f));
        v7.addCollisionListener(ve);

        getKnight().addCollisionListener(ve);
        getKnight().addCollisionListener(cp);

    }

    @Override
    public boolean isComplete() {
        if (getKnight().getCoins() == 3)
            return true;
        else return false;
    }

    @Override
    public void playMusicBackground() {
        gameMusic.loop();
    }

    @Override
    public void endMusicBackground(){
        gameMusic.stop();
    }
}
