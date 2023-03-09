package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {
    private Knight knight;
    private Coins coins;
    private SkeletonEncounter skeletonEncounter;

    public GameWorld() {
        super();

        // Create the knight character and position it
        knight = new Knight(this);
        knight.setPosition(new Vec2(-34, -13));
        knight.setGravityScale(2f);


        // Make a horizontal platforms in the middle//
        Shape MidPlatformShape1 = new BoxShape(3, 0.5f);
        StaticBody MidPlatform1 = new StaticBody(this, MidPlatformShape1);
        BodyImage MP1 = new BodyImage("data/Tileset/LandBlock.png", 5.5f);
        MidPlatform1.setClipped(true);
        MidPlatform1.addImage(MP1);
        MidPlatform1.setPosition(new Vec2(-5, -6.5f));

        // Make platforms on the left//
        Shape LeftPlatformShape1 = new BoxShape(3, 0.5f);
        StaticBody LeftPlatform1 = new StaticBody(this, LeftPlatformShape1);
        BodyImage LP1 = new BodyImage("data/Tileset/LandBlock.png", 6f);
        LeftPlatform1.setClipped(true);
        LeftPlatform1.addImage(LP1);
        LeftPlatform1.setPosition(new Vec2(-14, -11f));

        Shape LeftPlatformShape2 = new BoxShape(2, 0.5f);
        StaticBody LeftPlatform2 = new StaticBody(this, LeftPlatformShape2);
        BodyImage LP2 = new BodyImage("data/Tileset/LandBlock.png", 4f);
        LeftPlatform2.setClipped(true);
        LeftPlatform2.addImage(LP2);
        LeftPlatform2.setPosition(new Vec2(-19, -4f));

        Shape LeftPlatformShape3 = new BoxShape(2, 0.5f);
        StaticBody LeftPlatform3 = new StaticBody(this, LeftPlatformShape3);
        BodyImage LP3 = new BodyImage("data/Tileset/LandBlock.png", 4f);
        LeftPlatform3.setClipped(true);
        LeftPlatform3.addImage(LP3);
        LeftPlatform3.setPosition(new Vec2(-29, -1f));

        // Make platform on the right//
        Shape RightPlatformShape1 = new BoxShape(3, 0.5f);
        StaticBody RightPlatform1 = new StaticBody(this, RightPlatformShape1);
        BodyImage RP1 = new BodyImage("data/Tileset/LandBlock.png", 6f);
        RightPlatform1.setClipped(true);
        RightPlatform1.addImage(RP1);
        RightPlatform1.setPosition(new Vec2(6f, -5f));

        Shape RightPlatformShape2 = new BoxShape(3, 0.5f);
        StaticBody RightPlatform2 = new StaticBody(this, RightPlatformShape2);
        BodyImage RP2 = new BodyImage("data/Tileset/LandBlock.png", 6f);
        RightPlatform2.setClipped(true);
        RightPlatform2.addImage(RP2);
        RightPlatform2.setPosition(new Vec2(15f, -11f));

        // Make a ground platform//
        Shape groundShape = new BoxShape(40, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        BodyImage G = new BodyImage("data/Tileset/LandBlock.png", 100f);
        ground.setClipped(true);
        ground.addImage(G);
        ground.setPosition(new Vec2(0f, -15f));

        //add coins//
        CoinsPickup cp = new CoinsPickup(knight);
        Coins c1 = new Coins(this);
        c1.setPosition(new Vec2(-29f, 0.5f));
        c1.addCollisionListener(cp);

        Coins c2 = new Coins(this);
        c2.setPosition(new Vec2(-5f, -5f));
        c2.addCollisionListener(cp);

        knight.addCollisionListener(cp);

        //add skeleton collisions and skeleton into gameworld//
        SkeletonEncounter se = new SkeletonEncounter(knight);
        Skeleton sk = new Skeleton(this);
        sk.setPosition(new Vec2(7f, -2f));
        sk.addCollisionListener(se);

        Skeleton sk2 = new Skeleton(this);
        sk2.setPosition(new Vec2(2f, -12f));
        sk2.addCollisionListener(se);

        knight.addCollisionListener(se);
    }

    public Knight getKnight() {
        return knight;
    }
}

