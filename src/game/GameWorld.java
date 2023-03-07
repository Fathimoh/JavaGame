package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {
    private Knight knight;
    private Coins coins;

    public GameWorld() {
        super();

        // Create the knight character and position it
        knight = new Knight(this);
        knight.setPosition(new Vec2(-34, -13));
        knight.setName("Knight");
        knight.setGravityScale(1.0f);

        // Make a horizontal platforms in the middle//
        Shape MidPlatformShape1 = new BoxShape(3, 0.5f);
        StaticBody MidPlatform1 = new StaticBody(this, MidPlatformShape1);
        MidPlatform1.setPosition(new Vec2(-5, -6.5f));
        MidPlatform1.setName("MidPlat1");

        // Make platforms on the left//
        Shape LeftPlatformShape1 = new BoxShape(3, 0.5f);
        StaticBody LeftPlatform1 = new StaticBody(this, LeftPlatformShape1);
        LeftPlatform1.setPosition(new Vec2(-14, -11f));
        LeftPlatform1.setName("LeftPlat1");

        Shape LeftPlatformShape2 = new BoxShape(2, 0.5f);
        StaticBody LeftPlatform2 = new StaticBody(this, LeftPlatformShape2);
        LeftPlatform2.setPosition(new Vec2(-19, -4f));
        LeftPlatform2.setName("LeftPlat2");

        Shape LeftPlatformShape3 = new BoxShape(2, 0.5f);
        StaticBody LeftPlatform3 = new StaticBody(this, LeftPlatformShape3);
        LeftPlatform3.setPosition(new Vec2(-29, -1f));
        LeftPlatform3.setName("LeftPlat3");

        // Make platform on the right//
        Shape RightPlatformShape1 = new BoxShape(3, 0.5f);
        StaticBody RightPlatform1 = new StaticBody(this, RightPlatformShape1);
        RightPlatform1.setPosition(new Vec2(6f, -5f));
        RightPlatform1.setName("RightPlat1");

        Shape RightPlatformShape2 = new BoxShape(3, 0.5f);
        StaticBody RightPlatform2 = new StaticBody(this, RightPlatformShape2);
        RightPlatform2.setPosition(new Vec2(15f, -11f));
        RightPlatform2.setName("RightPlat2");

        // Make a ground platform//
        Shape groundShape = new BoxShape(40, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0f, -15f));
        ground.setName("ground");

        // Add skeleton enemies to the game//
        Skeleton skeleton1 = new Skeleton(this);
        skeleton1.setPosition(new Vec2(8, -2));
        skeleton1.setName("Skeleton");
        skeleton1.addCollisionListener(new SkeletonEncounter());

        Skeleton skeleton2 = new Skeleton(this);
        skeleton2.setPosition(new Vec2(6, -12f));
        skeleton2.setName("Skeleton");

        //add coins//
        CoinsPickup cp = new CoinsPickup(knight);
        Coins c1 = new Coins(this);
        c1.setPosition(new Vec2(-29f, 0.5f));
        c1.addCollisionListener(cp);

        Coins c2 = new Coins(this);
        c2.setPosition(new Vec2(-5f,-5f));
        c2.addCollisionListener(cp);

        knight.addCollisionListener(cp);

        //add skeleton collisions into gameworld//



    }

    public Knight getKnight() {
        return knight;
    }
}
