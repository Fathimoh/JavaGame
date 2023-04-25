package GameLevels;

import Objects.Coins;
import Objects.CoinsPickup;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import game.Game;
import Objects.Platform;
import Enemies.Skeleton;
import Enemies.SkeletonEncounter;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Level3 extends GameLevel {

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

    public Level3(Game game) {
        super(game);
        gameMusic.play();
        getKnight().setPosition(new Vec2(-34, -13));
        Shape PlatformShape = new BoxShape(3f, 0.5f);
        Shape groundPlatform = new BoxShape(40, 0.5f);

        //make platforms//
        Platform platform1 = new Platform(this, PlatformShape, -24f,-11f);

        Platform platform2 = new Platform(this, PlatformShape, -8.5f,-7f);
        Platform platform3 = new Platform(this, PlatformShape, -14f,-7f);
        Platform platform4 = new Platform(this, PlatformShape, -3f,-7f);
        Platform platform5 = new Platform(this, PlatformShape, 2f,-7f);
        Platform platform6 = new Platform(this, PlatformShape, 7f,-7f);
        Platform platform7 = new Platform(this, PlatformShape, 12f,-7f);
        Platform platform8 = new Platform(this, PlatformShape, 17f,-7f);
        Platform platform9 = new Platform(this, PlatformShape, 22f,-7f);

        Platform platform10 = new Platform(this, PlatformShape, 29f,-3f);
        Platform platform11 = new Platform(this, PlatformShape, 36f,1f);

        Platform platform12 = new Platform(this, PlatformShape, 22f,2.5f);
        Platform platform13 = new Platform(this, PlatformShape, 17f,2.5f);
        Platform platform14 = new Platform(this, PlatformShape, 12f,2.5f);
        Platform platform15 = new Platform(this, PlatformShape, 7f,2.5f);
        Platform platform16 = new Platform(this, PlatformShape, 2f,2.5f);
        Platform platform17 = new Platform(this, PlatformShape, -3f,2.5f);
        Platform platform18 = new Platform(this, PlatformShape, -8.5f,2.5f);
        Platform platform19 = new Platform(this, PlatformShape, -14f,2.5f);

        Platform platform20 = new Platform(this, PlatformShape, -24f,7f);
        Platform platform21 = new Platform(this, PlatformShape, -30f,-4f);


        //make ground platform//
        Platform platformG = new Platform(this, groundPlatform, 0f,-15f, "ground");

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

        //make skeletons//
        SkeletonEncounter se = new SkeletonEncounter(getKnight());
        Skeleton sk1 = new Skeleton(this);
        sk1.setPosition(new Vec2(25f, -12f));
        sk1.addCollisionListener(se);

        Skeleton sk2 = new Skeleton(this);
        sk2.setPosition(new Vec2(-5f, -12f));
        sk2.addCollisionListener(se);

        Skeleton sk3 = new Skeleton(this);
        sk3.setPosition(new Vec2(-6f, -4f));
        sk3.addCollisionListener(se);

        Skeleton sk4 = new Skeleton(this);
        sk4.setPosition(new Vec2(14f, -4f));
        sk4.addCollisionListener(se);

        Skeleton sk5 = new Skeleton(this);
        sk5.setPosition(new Vec2(14f, 5f));
        sk5.addCollisionListener(se);

        Skeleton sk6 = new Skeleton(this);
        sk6.setPosition(new Vec2(-6f, 5f));
        sk6.addCollisionListener(se);

        Skeleton sk7 = new Skeleton(this);
        sk7.setPosition(new Vec2(11f, -12f));
        sk7.addCollisionListener(se);

        getKnight().addCollisionListener(se);
        getKnight().addCollisionListener(cp);

    }

    @Override
    public boolean isComplete() {
        if (getKnight().getCoins() == 18)
            return true;
        else return false;
    }

    @Override
    public void endMusicBackground(){
        gameMusic.stop();
    }
}
