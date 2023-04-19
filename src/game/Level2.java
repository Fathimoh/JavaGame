package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public class Level2 extends GameLevel {

    public Level2(Game game) {
        super(game);
        getKnight().setPosition(new Vec2(-34, -13));
        Shape PlatformShape = new BoxShape(3f, 0.5f);
        Shape groundPlatform = new BoxShape(40, 0.5f);

        //Make platforms//
        Platform platform1 = new Platform(this, PlatformShape, -5f,-6.5f);
        Platform platform2 = new Platform(this, PlatformShape, -30f,2f);
        Platform platform3 = new Platform(this, PlatformShape, -30f,-9f);
        Platform platform4 = new Platform(this, PlatformShape, -16f,-2f);
        Platform platform5 = new Platform(this, PlatformShape, 30f,-11f);
        Platform platform6 = new Platform(this, PlatformShape, 30f,4f);
        Platform platform7 = new Platform(this, PlatformShape, 13f,-8f);
        Platform platform8 = new Platform(this, PlatformShape, -2f,2f);
        Platform platform9 = new Platform(this, PlatformShape, 13f,4f);
        Platform platform10 = new Platform(this, PlatformShape, -16,7f);
        // Make a ground platform//
        Platform platformG = new Platform(this, groundPlatform, 0f,-15f, "ground");

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

        //Make skeletons//
        SkeletonEncounter se = new SkeletonEncounter(getKnight());
        Skeleton sk1 = new Skeleton(this);
        sk1.setPosition(new Vec2(15f, -12f));
        sk1.addCollisionListener(se);

        Skeleton sk2 = new Skeleton(this);
        sk2.setPosition(new Vec2(-10f, -12f));
        sk2.addCollisionListener(se);

        Skeleton sk3 = new Skeleton(this);
        sk3.setPosition(new Vec2(-6f, -4f));
        sk3.addCollisionListener(se);

        Skeleton sk4 = new Skeleton(this);
        sk4.setPosition(new Vec2(-1f, 5f));
        sk4.addCollisionListener(se);

        Skeleton sk5 = new Skeleton(this);
        sk5.setPosition(new Vec2(-30f, -6f));
        sk5.addCollisionListener(se);

        Skeleton sk6 = new Skeleton(this);
        sk6.setPosition(new Vec2(-16f, 10f));
        sk6.addCollisionListener(se);

        Skeleton sk7 = new Skeleton(this);
        sk7.setPosition(new Vec2(30f, -8f));
        sk7.addCollisionListener(se);

        getKnight().addCollisionListener(se);
        getKnight().addCollisionListener(cp);
    }

    @Override
    public boolean isComplete() {
        if (getKnight().getCoins() == 12)
            return true;
        else return false;
    }

}
