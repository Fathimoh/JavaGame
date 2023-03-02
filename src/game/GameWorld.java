package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World{
    public GameWorld(){
        super();
        // populate it with bodies (ex: platforms, collectibles, characters)//
        // make a ground platform//
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // make a character (with an overlaid image)//
        Knight knight = new Knight(this);
        knight.setPosition(new Vec2(4,-5));

        // make a suspended platform//
        Shape platformShape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-8, -4f));
    }
}
