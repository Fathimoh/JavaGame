package Enemies;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * @author Fathi, Mohamed, Fathi.Mohamed@city.ac.uk
 */
public class Vulture extends Walker implements StepListener {
    /**
     * creates the hitbox of the enemy vulture
     */
    private static final Shape VultureShape = new PolygonShape(
            -1.1f,1.44f,
            -1.53f,-0.47f,
            -1.07f,-1.39f,
            -0.22f,-1.68f,
            0.79f,-1.59f,
            1.38f,-0.71f,
            1.18f,0.63f,
            0.59f,1.45f);
    /**
     * adds the images of the vulture
     */
    private static final BodyImage image = new BodyImage("data/Enemy/vultureLeft.gif", 4f);

    /**
     * the speed of the vulture when it moves
     */
    private final int SPEED = 2;
    /**
     * variables left and right used to know which direction the vulture is going
     */
    private float left,right;
    /**
     * this constructor will add the vulture to the world and make it functioning
     * @param world adds the vulture to the world with its image
     */
    public Vulture(World world){
        super(world, VultureShape);
        setGravityScale(0);
        addImage(image);
        world.addStepListener(this);
        startWalking(SPEED);
    }
    /**
     * this method will hold information about how far it will travel
     * @param position is used to accurately position the enemy in the x direction
     */
    public void setPosition(Vec2 position){
        int RANGE = 2;
        super.setPosition(position);
        left = position.x-RANGE;
        right = position.x+RANGE;
    }
    /**
     * this method will do the functioning of the enemy vulture and make it move
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