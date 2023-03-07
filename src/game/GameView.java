package game;
import city.cs.engine.*;

import java.awt.*;
import javax.swing.*;

public class GameView extends UserView {
    private final Image background1;
    private Knight knight;

    public GameView(GameWorld world, int width, int height) {
        super(world, width, height);
        this.background1 = new ImageIcon("data/BG.png").getImage();
    }


    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background1, 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        Font font  = new Font("Arial", Font.BOLD, 22);
        g.setFont(font);
        g.setColor(Color.WHITE);

        String CoinsCollected = "Coins: ";
        g.drawString(CoinsCollected,12, 20);
        //+ knight.getCoins();//    


    }


}

