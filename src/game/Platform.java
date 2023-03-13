package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Platform extends StaticBody {
    public Platform(World w, Shape shape, float x, float y) {
        super(w, shape);
        BodyImage image = new BodyImage("data/Tileset/LandBlock.png", 6f);
        this.setPosition(new Vec2(x,y));
        this.addImage(image);
        this.setClipped(true);

    }

    public Platform(World w, Shape shape, float x, float y, String type) {
        super(w, shape);
        BodyImage image = new BodyImage("data/Tileset/LandBlock.png", 100f);
        this.setPosition(new Vec2(x,y));
        this.addImage(image);
        this.setClipped(true);

    }
}
