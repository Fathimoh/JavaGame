package Enemies;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * @author Fathi, Mohamed, Fathi.Mohamed@city.ac.uk
 */
public class Beetle extends Walker implements StepListener {
    /**
     * creates the hitbox of the enemy beetle
     */
    private static final Shape BeetleShape = new PolygonShape(
            -1.16f,-1.63f,
            -1.39f,0.18f,
            -0.65f,1.66f,
            0.56f,1.72f,
            1.23f,0.28f,
            1.03f,-1.48f,
            0.69f,-1.66f);
    /**
     * adds the images of the beetle
     */
    private static final BodyImage image = new BodyImage("data/Enemy/beetle.gif", 4f);
    /**
     * the speed of the beetle when it moves
     */
    private final int SPEED = 2;
    /**
     * variables left and right used to know which direction the bettle is going
     */
    private float left,right;

    /**
     * this constructor will add the beetle to the world and make it functioning
     * @param world adds the beetle to the world with its image
     */
    public Beetle(World world){
        super(world, BeetleShape);
        setGravityScale(0);
        addImage(image);
        world.addStepListener(this);
        startWalking(SPEED);
        //this.setAlwaysOutline(true);
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
     * this method will do the functioning of the enemy bettle and make it move
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
