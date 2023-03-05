package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KnightController implements KeyListener {

    Knight knight;

    public KnightController(Knight knight){
        this.knight = knight;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed" + e.getKeyChar());

        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            knight.startWalking(-4);
        } else if (code == KeyEvent.VK_RIGHT) {
            knight.startWalking(4);
        } else if (code == KeyEvent.VK_UP) {
            knight.jump(8f);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
