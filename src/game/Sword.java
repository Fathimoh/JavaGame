package game;

import city.cs.engine.*;
public class Sword extends Walker{
    private static final Shape swordShape = new PolygonShape(
            0.22f,2.0f,
            2.19f,1.69f,
            3.1f,1.35f,
            3.69f,0.64f,
            3.86f,0.2f,
            3.84f,-0.54f,
            2.58f,-1.39f,
            0.72f,-1.63f);

    private static final BodyImage image =
            new BodyImage("data/Attack2Right", 4.0f);

    public Sword(World world) {
        super(world, swordShape);
        addImage(image);
        this.setAlwaysOutline(true);
    }
}
