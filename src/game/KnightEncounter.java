package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class KnightEncounter implements CollisionListener {

    private Knight knight;
    private Skeleton skeleton;
    private int health = 5;

    public KnightEncounter(Knight k) {
        knight = k;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Skeleton) {
            knight.setSkeleton(knight.getSkeletons() + 1);
            collisionEvent.getOtherBody();
            //skeleton.DecreaseSkeletonHealth();
            skeleton.destroy();
        }
    }
}
