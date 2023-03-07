package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class SkeletonEncounter implements CollisionListener {

    private Knight knight;
    private Skeleton skeleton;
    private int health = 5;

    public SkeletonEncounter(Knight k) {
        knight = k;
    }

//collision between the knight and the skeleton. Colliding with skeleton will make you die//
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Skeleton) {
            //knight.setSkeleton(knight.getSkeletons() + 1);
                collisionEvent.getOtherBody();
                knight.DecreaseKnightHealth();
                knight.destroy();
            }
        }
    }