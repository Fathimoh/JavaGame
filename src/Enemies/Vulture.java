package Enemies;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Vulture extends Walker implements StepListener {
    private static final Shape VultureShape = new PolygonShape(
            -1.1f,1.44f,
            -1.53f,-0.47f,
            -1.07f,-1.39f,
            -0.22f,-1.68f,
            0.79f,-1.59f,
            1.38f,-0.71f,
            1.18f,0.63f,
            0.59f,1.45f);
    private static final BodyImage image = new BodyImage("data/Enemy/vultureLeft.gif", 4f);

    private final int SPEED = 2;
    private float left,right;

    public Vulture(World world){
        super(world, VultureShape);
        setGravityScale(0);
        addImage(image);
        world.addStepListener(this);
        startWalking(SPEED);
    }

    public void setPosition(Vec2 position){
        int RANGE = 2;
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