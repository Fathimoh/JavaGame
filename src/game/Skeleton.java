package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Skeleton extends Walker implements StepListener {
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

    private final int SPEED = 2;
    private float left,right;
    //private final int health = 1;

    public Skeleton(World world){
        super(world, SkeletonShape);
        addImage(image);
        world.addStepListener(this);
        startWalking(SPEED);
        //this.setAlwaysOutline(true);
    }

   /* public void DecreaseSkeletonHealth(){
        health -= 1;
        System.out.println("Skeleton Health: "+ health);
    }
    */

    public void setPosition(Vec2 position){
        int RANGE = 1;
        super.setPosition(position);
        left = position.x-RANGE;
        right = position.x+RANGE;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if(getPosition().x > right){
            startWalking(-SPEED);
        }
        if(getPosition().x < left){
            startWalking(SPEED);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
