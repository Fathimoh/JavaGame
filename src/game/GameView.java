package game;
import GameLevels.GameLevel;
import GameLevels.Level1;
import GameLevels.Level2;
import GameLevels.Level3;
import city.cs.engine.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.*;

/**
 * @author Fathi, Mohamed, Fathi.Mohamed@city.ac.uk
 */

public class GameView extends UserView {
    /**
     * used to hold the image of level 1
     */
    private final Image backgroundLVL1;
    /**
     * used to hold the image of level 2
     */
    private final Image backgroundLVL2;
    /**
     * used to hold the image of level 3
     */
    private final Image backgroundLVL3;
    /**
     * used to hold coin image
     */
    private final Image Coin;
    /**
     * used to call the knight to the view
     */
    private Knight knight;
    private final Image Skull;
    private final Image Heart;
    private final Image beetle;
    private final Image vulture;
    private GameLevel level;

    /**
     * this constructor will initialise all images and icons and will also be used to give focus to the screen
     * @param world used to call level and use it when displaying backgrounds
     * @param width used to adjust the width of the images
     * @param height used to adjust the height of the images
     * @param knight used to display the stats of the knight
     */
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
        JCheckBox musicOffCheckBox = new JCheckBox();
        musicOffCheckBox.setBounds(900, 100, 50, 50);
        this.add(musicOffCheckBox);
        GiveFocus giveFocus = new GiveFocus(this);
        musicOffCheckBox.addMouseListener(giveFocus);
        /**
         * used to add a checkbox button on the gameview so the music can be turned off
         */
        musicOffCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (musicOffCheckBox.isSelected()) {
                    level.endMusicBackground();
                }
                else{
                    level.playMusicBackground();
                }
            }
        });

    }

    /**
     * used to display the background images of the levels
     * @param g used to print the images on the background
     */
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

    /**
     * used to display the stats of the character on the foreground
     * @param g used to print the image and writing on the foreground of the view
     */
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

        //display writing for music button//
        g.drawString("Music off", 530, 40);

        //draw images next to the statistics//
        int Width = 25;
        int Height = 22;
        g.drawImage(Coin, 143, 5, Width, Height, this);
        g.drawImage(Skull, 110, 35, Width, Height, this);
        g.drawImage(Heart, 148, 73, Width, Height, this);
        g.drawImage(beetle, 110, 100, 35, 35, this);
        g.drawImage(vulture, 110, 135, 35, 35, this);
    }

    /**
     * used to update the knight
     * @param knight
     */
    public void updateKnight(Knight knight){
        this.knight = knight;
    }

    /**
     * used to update the level
     * @param level
     */
    public void update(GameLevel level){
        this.level = level;
    }
}