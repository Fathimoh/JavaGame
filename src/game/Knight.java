package game;

import city.cs.engine.*;

public class Knight extends Walker {
    private static final Shape KnightShape = new PolygonShape(
            -0.45f,-0.08f,
            -1.21f,-1.1f,
            -1.1f,-2.9f,
            0.36f,-2.92f,
            0.4f,-1.52f,
            -0.05f,-0.1f);

    private static final BodyImage image = new BodyImage("data/Idle.gif", 6f);


    public Knight(World world){
        super(world, KnightShape);
        addImage(image);
    }
}
