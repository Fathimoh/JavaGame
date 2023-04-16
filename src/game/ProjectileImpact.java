package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class ProjectileImpact implements CollisionListener {
    private final Knight knight;
    private static SoundClip skeletonDeath;

    public ProjectileImpact(Knight knight){
        this.knight = knight;
    }

    static{
        try{
            skeletonDeath = new SoundClip("data/skeletonDeath.wav");
            skeletonDeath.setVolume(0.2);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if(collisionEvent.getOtherBody() instanceof Skeleton){
            knight.setSkeleton(knight.getSkeletons() + 1);
            skeletonDeath.play();
            collisionEvent.getOtherBody().destroy();
            collisionEvent.getReportingBody().destroy();
        }

        if(collisionEvent.getOtherBody() instanceof Platform || collisionEvent.getOtherBody() instanceof Coins){
            collisionEvent.getReportingBody().destroy();
        }
    }
}
