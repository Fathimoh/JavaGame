package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World{
    public GameWorld(){
        super();
        // populate it with bodies (ex: platforms, collectibles, characters)//
        // make a character (with an overlaid image)//
        Knight knight = new Knight(this);
        knight.setPosition(new Vec2(4,-5));

        // make a suspended platform//
        Shape platformShape = new BoxShape(2, 2.5f);
        StaticBody Brick = new StaticBody(this, platformShape);
        Brick.setPosition(new Vec2(-8, -4f));
        BodyImage image = new BodyImage("data/Tileset/BlockwPlat.png");
        Brick.addImage(image);

        // make a ground platform//
        Shape shape = new BoxShape(40, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -14.1f));
        BodyImage wideImage = new BodyImage("data/Tileset/BlockwPlat.png", 1.9f);
        ground.addImage(wideImage);

        //add skeleton to the game//
        Skeleton skeleton = new Skeleton(this);
        skeleton.setPosition(new Vec2(5,-1));

    }
}
