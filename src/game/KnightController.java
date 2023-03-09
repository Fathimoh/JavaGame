package game;

import city.cs.engine.BodyImage;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KnightController implements KeyListener {
    private final Knight knight;

    private boolean isRight;
    private boolean isLeft;

    private Slash attack;

    public KnightController(Knight knight) {
        this.knight = knight;
        this.attack = new Slash(knight.getWorld(), knight, this);
    }

    private void setIdleImage() {
        if (isLeft) {
            BodyImage image1 = new BodyImage("data/IdleLeft.gif", 4f);
            knight.removeAllImages();
            knight.addImage(image1);
        } else if (isRight) {
            BodyImage image2 = new BodyImage("data/IdleRight.gif", 4f);
            knight.removeAllImages();
            knight.addImage(image2);
        }
    }

    private void setAttackImage(float height, String attackImageFile) {
        BodyImage attackImage;
        if (isRight) {
            attackImage = new BodyImage(attackImageFile, 4);
            knight.removeAllImages();
            knight.addImage(attackImage);
        } else if (isLeft) {
            attackImage = new BodyImage(attackImageFile, 4);
            knight.removeAllImages();
            knight.addImage(attackImage);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("Key pressed " + e.getKeyChar());

        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            BodyImage image1 = new BodyImage("data/RunLeft.gif", 4f);
            knight.removeAllImages();
            knight.addImage(image1);
            knight.startWalking(-7f);
            isLeft = true;
            isRight = false;

        } else if (code == KeyEvent.VK_D) {
            BodyImage image2 = new BodyImage("data/RunRight.gif", 4f);
            knight.removeAllImages();
            knight.addImage(image2);
            knight.startWalking(7f);
            isRight = true;
            isLeft = false;

        } else if (code == KeyEvent.VK_W) {
            BodyImage image3 = new BodyImage("data/JumpLeft.gif", 4f);
            BodyImage image4 = new BodyImage("data/JumpRight.gif", 4f);

            if (isRight) {
                knight.removeAllImages();
                knight.addImage(image4);
                knight.jump(13.5f);

            } else if (isLeft) {
                knight.removeAllImages();
                knight.addImage(image3);
                knight.jump(13.5f);

            }

        } else if (code == KeyEvent.VK_LEFT) {

            isLeft = true;
            isRight = false;
            setAttackImage(4f, "data/Attack1Left.gif");
            attack.hit();

        } else if (code == KeyEvent.VK_RIGHT) {
            isRight = true;
            isLeft = false;
            setAttackImage(4f, "data/Attack2Right.gif");
            attack.hit();
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_A) {
            knight.startWalking(0);
            setIdleImage();

        } else if (code == KeyEvent.VK_D) {
            knight.startWalking(0);
            setIdleImage();

        } else if (code == KeyEvent.VK_LEFT) {
            setAttackImage(4f, "data/IdleLeft.gif");

        } else if (code == KeyEvent.VK_RIGHT) {
            setAttackImage(4f, "data/IdleRight.gif");
        }
    }
    public boolean isRight() {
        return isRight;
    }

    public boolean isLeft() {
        return isLeft;
    }
}
