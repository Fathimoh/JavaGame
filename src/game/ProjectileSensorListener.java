package game;

import Enemies.Beetle;
import Enemies.Skeleton;
import Enemies.Vulture;
import Objects.Coins;
import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * @author Fathi, Mohamed, Fathi.Mohamed@city.ac.uk
 */
public class ProjectileSensorListener implements SensorListener {

    private final Slash slash;

    private Knight knight;
    /**
     * field used to add sound to the enemies when they collide with the projectile
     */
    private static SoundClip skeletonDeath;
    static{
        try{
            skeletonDeath = new SoundClip("data/skeletonDeath.wav");
            skeletonDeath.setVolume(0.2);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }

    private static SoundClip beetleDeath;
    static {
        try {
            beetleDeath = new SoundClip("data/beetleDeathSound.wav");
            beetleDeath.setVolume(0.2);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    private static SoundClip vultureDeath;
    static {
        try {
            vultureDeath = new SoundClip("data/vultureDeath.wav");
            vultureDeath.setVolume(0.4);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * constructor used to initialise the slash projectile and the knight
     * @param slash used to detect collisions
     * @param knight used to release the projectile
     */
    public ProjectileSensorListener(Slash slash, Knight knight) {
        this.slash = slash;
        this.knight = knight;
    }

    /**
     * this method has a function of detecting the collision between enemies, coins and platforms
     * when the projectile hits an enemy it will destory that enemy, if the projectile hits the platform then the projectile will be destroyed, the projectile goes through coins as well
     * @param sensorEvent used to make the projectile detect specific collisions
     */
    @Override
    public void beginContact(SensorEvent sensorEvent) {
        if(!(sensorEvent.getContactBody() instanceof Knight || sensorEvent.getContactBody() instanceof Coins)){
            slash.destroy();
        }
        if(sensorEvent.getContactBody() instanceof Skeleton skeleton){
            skeleton.destroy();
            skeletonDeath.play();
            knight.setSkeleton(knight.getSkeletons() + 1);
        }
        if(sensorEvent.getContactBody() instanceof Beetle beetle){
            beetle.destroy();
            beetleDeath.play();
            knight.setBeetle(knight.getBeetle() + 1);
        }
        if(sensorEvent.getContactBody() instanceof Vulture vulture){
            vulture.destroy();
            vultureDeath.play();
            knight.setVulture(knight.getVulture() + 1);
        }
    }
    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
