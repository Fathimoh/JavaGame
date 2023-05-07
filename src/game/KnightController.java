package game;

import city.cs.engine.BodyImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Fathi, Mohamed, Fathi.Mohamed@city.ac.uk
 */
public class KnightController implements KeyListener {
    private Knight knight;
    /**
     * used to determine whether the knight is standing facing the left direction or the right direction
     */
    private boolean isRight;
    private boolean isLeft;

    private Slash attack;

    public KnightController(Knight knight) {
        this.knight = knight;
    }

    /**
     * method used to set the character to standing images when its either facing left or right
     * this method will be called when the user is not clicking anything (knight is idle)
     */
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

    /**
     * This method will be used to set the character image to attacking when its facing left or right
     * this method will be called when the user click the 2 hitting buttons (left arrow/right arrow)
     * @param height used to display the size of the image
     * @param attackImageFile used as a variable to take in the image of the knight
     */
    private void setAttackImage(float height, String attackImageFile) {
        BodyImage attackImage;
        if (isRight) {
            attackImage = new BodyImage(attackImageFile, 4);
        } else if (isLeft) {
            attackImage = new BodyImage(attackImageFile, 4);
        } else {
            return;
        }
        knight.removeAllImages();
        knight.addImage(attackImage);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * This method will be used to make the character move
     * this method has various functionality, each key when click will do something (d will make the player move right...)
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            BodyImage image1 = new BodyImage("data/RunLeft.gif", 4f);
            knight.removeAllImages();
            knight.addImage(image1);
            knight.startWalking(-13f);
            isLeft = true;
            isRight = false;    

        } else if (code == KeyEvent.VK_D) {
            BodyImage image2 = new BodyImage("data/RunRight.gif", 4f);
            knight.removeAllImages();
            knight.addImage(image2);
            knight.startWalking(13f);
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
            attack = new Slash(knight.getWorld(), knight, "left");

        } else if (code == KeyEvent.VK_RIGHT) {
            isRight = true;
            isLeft = false;
            setAttackImage(4f, "data/Attack2Right.gif");
            attack = new Slash(knight.getWorld(), knight, "right");
        }
    }

    /**
     * this method is used when the user releases the keys that were pressed
     * releasing the keys will make the character return to its original state
     * @param e the event to be processed
     */
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
            isLeft = true;
            isRight = false;
            setIdleImage();

        } else if (code == KeyEvent.VK_RIGHT) {
            isRight = true;
            isLeft = false;
            setIdleImage();
        }
    }

    /**
     * used to update the knight as the levels progress
     * @param knight
     */
    public void updateKnight(Knight knight) {
        this.knight = knight;
    }
}
