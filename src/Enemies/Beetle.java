package Enemies;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Beetle extends Walker implements StepListener {
    private static final Shape BeetleShape = new PolygonShape(
            -1.16f,-1.63f,
            -1.39f,0.18f,
            -0.65f,1.66f,
            0.56f,1.72f,
            1.23f,0.28f,
            1.03f,-1.48f,
            0.69f,-1.66f);
    private static final BodyImage image = new BodyImage("data/Enemy/beetle.gif", 4f);

    private final int SPEED = 2;
    private float left,right;

    public Beetle(World world){
        super(world, BeetleShape);
        setGravityScale(0);
        addImage(image);
        world.addStepListener(this);
        startWalking(SPEED);
        //this.setAlwaysOutline(true);
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
