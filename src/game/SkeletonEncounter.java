package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class SkeletonEncounter implements CollisionListener {

    private Knight knight;



    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Skeleton) {
            knight.setSkeleton(knight.getSkeletons()+1);
            collisionEvent.getOtherBody().destroy();
            knight.DecreaseHealth();
            knight.destroy();
        }
    }
}
