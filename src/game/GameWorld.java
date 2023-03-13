package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {
    private final Knight knight;

    public GameWorld() {
        super();

        // Create the knight character and position it
        knight = new Knight(this);
        knight.setPosition(new Vec2(-34, -13));
        knight.setGravityScale(2f);


        // Make a horizontal platforms in the middle//
        Shape PlatformShape = new BoxShape(3f, 0.5f);
        Shape groundPlatform = new BoxShape(40, 0.5f);

        Platform platform2 = new Platform(this, PlatformShape, -5f,-6.5f);

        Platform platform3 = new Platform(this, PlatformShape, -6f,3.5f);

        // Make platforms on the left//
        Platform platform1 = new Platform(this,PlatformShape, -14,-11);

        Platform platform4 = new Platform(this,PlatformShape,-19f,-4);

        Platform platform5 = new Platform(this, PlatformShape,-29f,-1f);

        Platform platform6 = new Platform(this,PlatformShape, -18f,3.5f);

        Platform platform7 = new Platform(this,PlatformShape, 6f,-5f);

        Platform platform8 = new Platform(this,PlatformShape, 15f,-11f);

        Platform platform9 = new Platform(this, PlatformShape, 7f,3.5f);

        // Make a ground platform//
        Platform platformG = new Platform(this, groundPlatform, 0f,-15f, "ground");

        //add coins//
        CoinsPickup cp = new CoinsPickup(knight);
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

        knight.addCollisionListener(cp);

        //add skeleton collisions and skeleton into gameWorld//
        SkeletonEncounter se = new SkeletonEncounter(knight);
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

        knight.addCollisionListener(se);
    }

    public Knight getKnight() {
        return knight;
    }
}

//make a class for platforms, so it can be called with fewer lines//
