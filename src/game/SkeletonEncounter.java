package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class SkeletonEncounter implements CollisionListener {

    private final Knight knight;

    public SkeletonEncounter(Knight k) {
        knight = k;
    }

    //collision between the knight and the skeleton. Colliding with skeleton will make you die//
    @Override
    public void collide(CollisionEvent collisionEvent) {
        //int health = 3;
        if (collisionEvent.getOtherBody() instanceof Knight) {
            collisionEvent.getOtherBody();
            knight.DecreaseKnightHealth();
            if (knight.getHealth() <= 0) {
                knight.destroy();
                System.exit(0);
            }
        }
    }
}