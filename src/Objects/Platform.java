package Objects;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Platform extends StaticBody{
    //dirt platforms//
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

//brick platforms//
    public Platform(World w, Shape shape, float x, float y, boolean type) {
        super(w, shape);
        BodyImage image = new BodyImage("data/Tileset/HorizontalBlockwPlat.png", 6f);
        this.setPosition(new Vec2(x,y));
        this.addImage(image);
        this.setClipped(true);
    }

    public Platform(World w, Shape shape, float x, float y, int type) {
        super(w, shape);
        BodyImage image = new BodyImage("data/Tileset/HorizontalBlockwPlat.png", 100f);
        this.setPosition(new Vec2(x,y));
        this.addImage(image);
        this.setClipped(true);
    }

    public Platform(World w, Shape shape, float x, float y, float type){
        super(w, shape);
        BodyImage image = new BodyImage("data/Tileset/dirt2.png", 2f);
        this.setPosition(new Vec2(x,y));
        this.addImage(image);
        this.setClipped(true);
    }

    public Platform(World w, Shape shape, float x, float y, char type){
        super(w, shape);
        BodyImage image = new BodyImage("data/Tileset/dirtFloor.jpg", 50f);
        this.setPosition(new Vec2(x,y));
        this.addImage(image);
        this.setClipped(true);
    }

}
