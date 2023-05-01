package GameLevels;

import Enemies.MobsEncounter;
import Enemies.Skeleton;
import Enemies.SkeletonEncounter;
import Objects.Coins;
import Objects.CoinsPickup;
import Objects.JumpPad;
import Objects.Platform;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import game.*;
import org.jbox2d.common.Vec2;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Level1 extends GameLevel {
    private static SoundClip gameMusic;

    private GameView view;

    static {
        try {
            gameMusic = new SoundClip("data/field_theme_1.wav");
            gameMusic.setVolume(1);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    public Level1(Game game){
        super(game);
        getKnight().setPosition(new Vec2(-34, -13));
        Shape PlatformShape = new BoxShape(3f, 0.5f);
        Shape groundPlatform = new BoxShape(40, 0.5f);

        JumpPad jumpPad = new JumpPad(this, true);
        jumpPad.setPosition(new Vec2(21f, -13.5f));

        new Platform(this, PlatformShape, -5f,-6.5f);
        new Platform(this, PlatformShape, -6f,3.5f);
        new Platform(this,PlatformShape, -14,-11);
        new Platform(this,PlatformShape,-19f,-4);
        new Platform(this, PlatformShape,-29f,-1f);
        new Platform(this,PlatformShape, -18f,3.5f);
        new Platform(this,PlatformShape, 6f,-5f);
        new Platform(this,PlatformShape, 15f,-11f);
        new Platform(this, PlatformShape, 7f,3.5f);
        new Platform(this, PlatformShape, 25f,-7f);
        // Make a ground platform//
        new Platform(this, groundPlatform, 0f,-15f, "ground");

        //add coins//
        CoinsPickup cp = new CoinsPickup(getKnight(), this, game);
        Coins c1 = new Coins(this);
        c1.setPosition(new Vec2(-29f, 0.5f));
        c1.addCollisionListener(cp);

        Coins c2 = new Coins(this);
        c2.setPosition(new Vec2(-5f, -5f));
        c2.addCollisionListener(cp);

        Coins c3 = new Coins(this);
        c3.setPosition(new Vec2(-18f, 5f));
        c3.addCollisionListener(cp);

        Coins c4 = new Coins(this);
        c4.setPosition(new Vec2(-21f, -2.5f));
        c4.addCollisionListener(cp);

        Coins c5 = new Coins(this);
        c5.setPosition(new Vec2(7f, 5f));
        c5.addCollisionListener(cp);

        Coins c6 = new Coins(this);
        c6.setPosition(new Vec2(15f, -9.4f));
        c6.addCollisionListener(cp);


        //add skeleton collisions and skeleton into gameWorld//
        SkeletonEncounter se = new SkeletonEncounter(getKnight(), game);
        Skeleton sk = new Skeleton(this);
        sk.setPosition(new Vec2(7f, -2f));
        sk.addCollisionListener(se);

        Skeleton sk2 = new Skeleton(this);
        sk2.setPosition(new Vec2(2f, -12f));
        sk2.addCollisionListener(se);

        Skeleton top = new Skeleton(this);
        top.setPosition(new Vec2(-6f, 6.5f));
        top.addCollisionListener(se);

        Skeleton sk4 = new Skeleton(this);
        sk4.setPosition(new Vec2(-21f, -12f));
        sk4.addCollisionListener(se);

        Skeleton sk5 = new Skeleton(this);
        sk5.setPosition(new Vec2(-18f, -1.1f));
        sk5.addCollisionListener(se);

        getKnight().addCollisionListener(se);
        getKnight().addCollisionListener(cp);
    }
    @Override
    public boolean isComplete() {
        return getKnight().getCoins() == 6;
    }

    @Override
    public void playMusicBackground(){
        gameMusic.loop();
    }
    @Override
    public void endMusicBackground(){
        gameMusic.stop();
    }

    @Override
    public void updateView(GameView view) {
        this.view = view;
    }
}

