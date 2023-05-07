package Enemies;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * @author Fathi, Mohamed, Fathi.Mohamed@city.ac.uk
 */
public class Skeleton extends Walker implements StepListener {
    /**
     * makes the hitbox of the enemy skeleton
     */
    private static final Shape SkeletonShape = new PolygonShape(
            -0.38f,1.56f,
            -0.99f,0.4f,
            -1.04f,-1.07f,
            -0.68f,-2.41f,
            0.36f,-2.42f,
            0.81f,-1.13f,
            0.82f,0.33f,
            0.17f,1.56f);
    /**
     * adds the image to the shape
     */
    private static final BodyImage image = new BodyImage("data/Enemy/SkeletonStandingLeft.png", 5f);
    /**
     * speed to know how fast the skeleton moves
     */
    private final int SPEED = 2;
    /**
     * left and right used to know the direction which it will be moving
     */
    private float left,right;

    /**
     * this constructor will add the skeleton to the world and make it functioning
     * @param world adds the skeleton to the world with its image
     */
    public Skeleton(World world){
        super(world, SkeletonShape);
        addImage(image);
        world.addStepListener(this);
        startWalking(SPEED);
    }

    /**
     * this method will hold information about how far it will travel
     * @param position is used to accurately position the enemy in the x direction
     */
    public void setPosition(Vec2 position){
        int RANGE = 1;
        super.setPosition(position);
        left = position.x-RANGE;
        right = position.x+RANGE;
    }

    /**
     * this method will do the functioning of the enemy skeleton and make it move
     * @param stepEvent makes the enemy start moving
     */
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
