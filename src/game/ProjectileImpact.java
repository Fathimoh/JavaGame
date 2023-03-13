package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class ProjectileImpact implements CollisionListener {
    private Knight knight;
    private Skeleton skeleton;

    public ProjectileImpact(Knight knight){
        this.knight = knight;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if(collisionEvent.getOtherBody() instanceof Skeleton){
            knight.setSkeleton(knight.getSkeletons() + 1);
            collisionEvent.getOtherBody().destroy();
            collisionEvent.getReportingBody().destroy();
        }

        if(collisionEvent.getOtherBody() instanceof Platform || collisionEvent.getOtherBody() instanceof Coins){
            collisionEvent.getReportingBody().destroy();
        }
    }
}
