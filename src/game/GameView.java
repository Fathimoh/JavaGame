package game;
import city.cs.engine.*;

import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.*;

public class GameView extends UserView {
    private final Image background;
    private final Image Coin;
    private Knight knight;
    private Font font;

    public GameView(GameWorld world, int width, int height, Knight knight) {
        super(world, width, height);
        this.background = new ImageIcon("data/BG.png").getImage();
        this.Coin = new ImageIcon("data/StaticCoin.jpg").getImage();
        this.knight = knight;
    }


    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        try{
            //Calls out the font file saved in data//
            InputStream f = new FileInputStream("data/PixelFont.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, f).deriveFont(Font.BOLD, 25f);
        } catch (Exception e){
            //when an error happens and the file is not read then the font will change to arial//
            System.err.println("failed to load file" + e.getMessage());
            font = new Font("Arial", Font.BOLD, 30);
        }

        g.setFont(font);
        g.setColor(Color.ORANGE);

        //coin stats displays//
        String CoinsCollected = "Coins: " + knight.getCoins();
        g.drawString(CoinsCollected,9, 43);

        //Skeleton kills displays//
        String Kills = "Kills: " + knight.getSkeletons();
        g.drawString(Kills, 9, 80);
       // g.setColor(Color.RED);

        int coinWidth = 20;
        int coinHeight = 20;
        //g.drawImage(Coin, 27, 8, coinWidth, coinHeight, this);

    }
}

