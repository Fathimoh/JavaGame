package game;
import GameLevels.GameLevel;
import GameLevels.Level1;
import GameLevels.Level2;
import GameLevels.Level3;
import city.cs.engine.*;

import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.*;

public class GameView extends UserView {
    private final Image backgroundLVL1;
    private final Image backgroundLVL2;
    private final Image backgroundLVL3;
    private final Image Coin;
    private Knight knight;
    private final Image Skull;
    private final Image Heart;
    private final Image beetle;
    private final Image vulture;
    private GameLevel level;

    public GameView(GameLevel world, int width, int height, Knight knight) {
        super(world, width, height);
        this.backgroundLVL1 = new ImageIcon("data/BG.png").getImage();
        this.backgroundLVL2 = new ImageIcon("data/DungeonBackground.jpg").getImage();
        this.backgroundLVL3 = new ImageIcon("data/LVL3Background1.png").getImage();
        this.Coin = new ImageIcon("data/StaticCoin.jpg").getImage();
        this.Skull = new ImageIcon("data/Skull.jpg").getImage();
        this.Heart = new ImageIcon("data/Heart.jpg").getImage();
        this.beetle = new ImageIcon("data/beetleImage.png").getImage();
        this.vulture = new ImageIcon("data/v.png").getImage();
        this.knight = knight;
        this.level = world;
    }


    @Override
    protected void paintBackground(Graphics2D g) {
        if (level instanceof Level1) {
            g.drawImage(backgroundLVL1, 0, 0, this);
        }
        if(level instanceof Level2){
            g.drawImage(backgroundLVL2, 0, 0, this);
        }
        if(level instanceof Level3){
            g.drawImage(backgroundLVL3, 0, 0, this);
        }
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        Font font;
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
        g.setColor(Color.YELLOW);

        //coin stats displays//
        String CoinsCollected = "Coins: " + knight.getCoins();
        g.drawString(CoinsCollected,9, 43);

        //Skeleton kills displays//
        String SkeletonKills = "Kills: " + knight.getSkeletons();
        g.drawString(SkeletonKills, 9, 75);

        //Displays the health count//
        String Lives = "Health: " + knight.getHealth();
        g.drawString(Lives, 9, 110);

        //displays beetle kills//
        String BeetleKills = "Kills: " + knight.getBeetle();
        g.drawString(BeetleKills, 9, 145);

        //displays vulture kills//
        String VultureKills = "kills: " + knight.getVulture();
        g.drawString(VultureKills, 9, 180);

        //draw images next to the statistics//
        int Width = 25;
        int Height = 22;
        g.drawImage(Coin, 141, 5, Width, Height, this);
        g.drawImage(Skull, 110, 35, Width, Height, this);
        g.drawImage(Heart, 148, 73, Width, Height, this);
        g.drawImage(beetle, 110, 100, 35, 35, this);
        g.drawImage(vulture, 110, 135, 35, 35, this);
    }

    public void updateKnight(Knight knight){
        this.knight = knight;
    }

    public void update(GameLevel level){
        this.level = level;
    }
}

