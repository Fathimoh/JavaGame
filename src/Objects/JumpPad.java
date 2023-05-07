package Objects;

import city.cs.engine.*;
import game.Knight;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
/**
 * @author Fathi, Mohamed, Fathi.Mohamed@city.ac.uk
 */
public class JumpPad extends StaticBody implements CollisionListener {

    private static final Shape shape = new BoxShape(1, 0.5f);
    private static final BodyImage image1 = new BodyImage("data/LaunchPad.png", 4f);
    private static final BodyImage image2 = new BodyImage("data/JumpPad.png", 4f);

    private static SoundClip JumpSound;
    static {
        try {
            JumpSound = new SoundClip("data/JumpPadSound.wav");
            JumpSound.setVolume(0.3);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * A constructor of jumpPad that is used to create a jumpPad and add the collision listener
     * @param world used so it can access and display it in the world
     */
    public JumpPad(World world) {
        super(world, shape);
        addImage(image1);
        this.addCollisionListener(this);
    }

    /**
     * another constructor of jumpPad that is used to create a jumpPad and add the collision listener
     * @param world used so it can access and display it in the world
     * @param type used to differ from the other constructor, so it can display another image instead
     */
    public JumpPad(World world, boolean type) {
        super(world, shape);
        addImage(image2);
        new SolidFixture(this, shape);
        this.addCollisionListener(this);
    }

    /**
     * method that detects the collision between the knight and the jumpPad
     * when the knight collides with the jumpPad, the knight will move up in the y-axis with a speed of 30
     * @param e used to detect collisions
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Knight knight) {
            knight.jump(30);
            JumpSound.play();
        }
    }
}