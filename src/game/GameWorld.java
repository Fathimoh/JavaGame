package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {
    private Knight knight;

    public GameWorld() {
        super();

        // Create the knight character and position it
        knight = new Knight(this);
        knight.setPosition(new Vec2(4, -5));

        // Make a suspended platform
        Shape platformShape = new BoxShape(2, 2.5f);
        StaticBody brick = new StaticBody(this, platformShape);
        brick.setPosition(new Vec2(-8, -4f));
        BodyImage brickImage = new BodyImage("data/Tileset/BlockwPlat.png");
        brick.addImage(brickImage);

        // Make a ground platform
        Shape groundShape = new BoxShape(40, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0f, -14.1f));
        BodyImage groundImage = new BodyImage("data/Tileset/BlockwPlat.png", 1.9f);
        ground.addImage(groundImage);

        // Add a skeleton enemy to the game
        Skeleton skeleton = new Skeleton(this);
        skeleton.setPosition(new Vec2(5, -1));
    }

    public Knight getKnight() {
        return knight;
    }
}
