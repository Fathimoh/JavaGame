package Objects;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 * @author Fathi, Mohamed, Fathi.Mohamed@city.ac.uk
 */
public class Platform extends StaticBody{
    //land blocks//

    /**
     * each constructor is the same but another parameter is added in order to differ from the rest of the constructors
     * @param w used to add the platform into the world
     * @param shape used to set the shape of the platform
     * @param x used to set the x position of the platform
     * @param y used to set the y position of the platform
     */
    public Platform(World w, Shape shape, float x, float y) {
        super(w, shape);
        BodyImage image = new BodyImage("data/Tileset/LandBlock.png", 6f);
        this.setPosition(new Vec2(x,y));
        this.addImage(image);
        this.setClipped(true);

    }
//land block for ground//
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
//horizontal block platform for ground//
    public Platform(World w, Shape shape, float x, float y, int type) {
        super(w, shape);
        BodyImage image = new BodyImage("data/Tileset/HorizontalBlockwPlat.png", 100f);
        this.setPosition(new Vec2(x,y));
        this.addImage(image);
        this.setClipped(true);
    }
//dirt block//
    public Platform(World w, Shape shape, float x, float y, float type){
        super(w, shape);
        BodyImage image = new BodyImage("data/Tileset/dirt2.png", 2f);
        this.setPosition(new Vec2(x,y));
        this.addImage(image);
        this.setClipped(true);
    }
//dirt block for ground//
    public Platform(World w, Shape shape, float x, float y, char type){
        super(w, shape);
        BodyImage image = new BodyImage("data/Tileset/dirtFloor.jpg", 50f);
        this.setPosition(new Vec2(x,y));
        this.addImage(image);
        this.setClipped(true);
    }

}
