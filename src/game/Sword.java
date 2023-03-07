package game;

import city.cs.engine.*;
public class Sword extends Walker{
    private static final Shape swordShape = new PolygonShape(
            -0.28f,1.98f,
            3.08f,1.33f,
            3.78f,0.31f,
            3.87f,-0.55f,
            1.59f,-1.68f,
            -0.21f,-1.96f,
            -3.85f,-1.88f,
            -0.52f,1.87f);

    private static final BodyImage image = new BodyImage("data/Attack2Right.gif", 4.0f);
    public Sword(World world, Knight knight) {
        super(world, swordShape);
        addImage(image);
        this.setPosition(knight.getPosition());
        //this.setAlwaysOutline(true);
    }
}
