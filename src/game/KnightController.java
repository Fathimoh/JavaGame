package game;

import city.cs.engine.BodyImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KnightController implements KeyListener {

    Knight knight;
    private static boolean IsRight;
    private static boolean IsLeft;
    private static boolean Jumping;

    public KnightController(Knight knight) {
        this.knight = knight;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed " + e.getKeyChar());

        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            BodyImage image1 = new BodyImage("data/RunLeft.gif",8f);
            knight.removeAllImages();
            knight.addImage(image1);
            knight.startWalking(-5);
            IsLeft = true;
            IsRight = false;
            Jumping = false;

        } else if (code == KeyEvent.VK_D) {
            BodyImage image2 = new BodyImage("data/RunRight.gif",8f);
            knight.removeAllImages();
            knight.addImage(image2);
            knight.startWalking(5);
            IsRight = true;
            IsLeft = false;
            Jumping = false;

        } else if (code == KeyEvent.VK_W) {
            BodyImage image3 = new BodyImage("data/JumpLeft.gif",8f);
            BodyImage image4 = new BodyImage("data/JumpRight.gif",8f);

            if(IsRight == true && IsLeft == false){
                knight.removeAllImages();
                knight.addImage(image4);
                knight.jump(8f);
                Jumping = true;

            } else if(IsLeft == true && IsRight == false){
                knight.removeAllImages();
                knight.addImage(image3);
                knight.jump(8f);
                Jumping = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_A) {
            knight.stopWalking();
            BodyImage image1 = new BodyImage("data/IdleLeft.gif",8f);
            knight.removeAllImages();
            knight.addImage(image1);

        } else if (code == KeyEvent.VK_D) {
            knight.stopWalking();
            BodyImage image2 = new BodyImage("data/IdleRight.gif",8f);
            knight.removeAllImages();
            knight.addImage(image2);
        }
    }
}