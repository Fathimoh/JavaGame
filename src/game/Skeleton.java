package game;

import city.cs.engine.*;

public class Skeleton extends DynamicBody {
    private static final Shape SkeletonShape = new PolygonShape(
            -0.12f,1.26f,
            -0.69f,-0.13f,
            -0.69f,-0.94f,
            -0.33f,-1.93f,
            0.54f,-1.94f,
            0.84f,-0.82f,
            0.81f,0.27f,
            0.35f,1.23f);
    private static final BodyImage image = new BodyImage("data/Enemy/SkeletonStandingLeft.png", 4f);


    public Skeleton(World world){
        super(world, SkeletonShape);
        addImage(image);
    }

}
