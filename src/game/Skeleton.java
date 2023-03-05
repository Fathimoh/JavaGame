package game;

import city.cs.engine.*;

public class Skeleton extends DynamicBody {
    private static final Shape SkeletonShape = new PolygonShape(
            -0.38f,1.56f,
            -0.99f,0.4f,
            -1.04f,-1.07f,
            -0.68f,-2.41f,
            0.36f,-2.42f,
            0.81f,-1.13f,
            0.82f,0.33f,
            0.17f,1.56f);
    private static final BodyImage image = new BodyImage("data/Enemy/SkeletonStandingLeft.png", 5f);


    public Skeleton(World world){
        super(world, SkeletonShape);
        addImage(image);
        this.setAlwaysOutline(true);
    }

}
