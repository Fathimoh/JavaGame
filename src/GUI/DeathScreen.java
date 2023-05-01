package GUI;

import GameLevels.GameLevel;
import game.Game;
import game.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;

public class DeathScreen {
    private GameLevel level;
    private JButton playAgainButton;
    public JPanel mainPanel;
    private JButton quitButton;

    public DeathScreen(JFrame frame, GameLevel level, GameView view, Game game){
        Font font;
        Font buttonFont;
        try{
            //Calls out the font file saved in data//
            InputStream f = new FileInputStream("data/PixelFont.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, f).deriveFont(Font.BOLD, 50f);
        } catch (Exception e){
            //when an error happens and the file is not read then the font will change to arial//
            System.err.println("failed to load file" + e.getMessage());
            font = new Font("Arial", Font.BOLD, 30);
        }

        try{
            //Calls out the font file saved in data//
            InputStream f = new FileInputStream("data/PixelFont.ttf");
            buttonFont = Font.createFont(Font.TRUETYPE_FONT, f).deriveFont(Font.BOLD, 15f);
        } catch (Exception e){
            //when an error happens and the file is not read then the font will change to arial//
            System.err.println("failed to load file" + e.getMessage());
            buttonFont = new Font("Arial", Font.BOLD, 30);
        }

        JLabel backgroundLabel = new JLabel(new ImageIcon("data/MBG.png"));
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        mainPanel.setLayout(new OverlayLayout(mainPanel));

        // Add the background image label as the bottom layer
        mainPanel.add(backgroundLabel);

        // Set the layout manager of backgroundLabel to null to allow custom positioning
        backgroundLabel.setLayout(null);

        // Set the bounds of the buttons relative to the background image
        playAgainButton.setBounds(550, 250, 300, 40);
        quitButton.setBounds(650, 300, 100, 40);

        // Add the buttons to the background image label
        backgroundLabel.add(playAgainButton);
        backgroundLabel.add(quitButton);

        playAgainButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);

        JLabel textLabel = new JLabel("The End");
        textLabel.setFont(font);
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(570, -100, 900, 400);
        backgroundLabel.add(textLabel);
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.restartLevel();
                level.playMusicBackground();
                view.setVisible(true);
                frame.add(view);
                mainPanel.setVisible(false);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void updateLevel(GameLevel level){
        this.level = level;
    }
}
