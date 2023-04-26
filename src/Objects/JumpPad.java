package Objects;

import city.cs.engine.*;
import game.Knight;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class JumpPad extends StaticBody implements CollisionListener {

    private static final Shape shape = new BoxShape(1, 0.5f);
    private static final BodyImage image1 = new BodyImage("data/LaunchPad.png", 4f);
    private static final BodyImage image2 = new BodyImage("data/JumpPad.png", 3f);

    private static SoundClip JumpSound;
    static {
        try {
            JumpSound = new SoundClip("data/JumpPadSound.wav");
            JumpSound.setVolume(0.3);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public JumpPad(World world) {
        super(world, shape);
        addImage(image1);
        SolidFixture fixture = new SolidFixture(this, shape);
        this.addCollisionListener(this);
        //this.setAlwaysOutline(true);
    }

    public JumpPad(World world, boolean type) {
        super(world, shape);
        addImage(image2);
        SolidFixture fixture = new SolidFixture(this, shape);
        this.addCollisionListener(this);
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Knight knight) {
            knight.applyImpulse(new Vec2(0, 500));
            JumpSound.play();
        }
    }
}