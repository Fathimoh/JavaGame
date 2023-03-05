package game;

import city.cs.engine.*;

public class Knight extends Walker {
    private static final Shape KnightShape = new PolygonShape(
            -0.05f,2.0f,
            -1.11f,0.69f,
            -0.89f,-1.97f,
            0.99f,-1.98f,
            1.09f,-0.59f,
            0.7f,1.63f,
            0.37f,1.97f);


    private static final BodyImage image = new BodyImage("data/IdleRight.gif", 4f);


    public Knight(World world){
        super(world, KnightShape);
        addImage(image);
        this.setAlwaysOutline(true);
    }
}
