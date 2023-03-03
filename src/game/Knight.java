package game;

import city.cs.engine.*;

public class Knight extends DynamicBody {
    private static final Shape KnightShape = new PolygonShape(
            -0.29f,-0.04f,
            -0.85f,-0.83f,
            -0.71f,-1.95f,
            0.22f,-1.97f,
            0.3f,-1.07f,
            0.0f,-0.1f);

    private static final BodyImage image = new BodyImage("data/Idle.gif", 4f);


    public Knight(World world){
        super(world, KnightShape);
        addImage(image);
    }
}
