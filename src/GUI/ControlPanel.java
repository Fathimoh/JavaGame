package GUI;

import GameLevels.GameLevel;
import game.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;

public class ControlPanel {
    private GameLevel level;
    private JButton playButton;
    public JPanel mainPanel;
    private JButton quitButton;

    public ControlPanel(JFrame frame, GameLevel level, GameView view) {
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
        playButton.setBounds(550, 250, 300, 40);
        quitButton.setBounds(650, 300, 100, 40);

        // Add the buttons to the background image label
        backgroundLabel.add(playButton);
        backgroundLabel.add(quitButton);

        playButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);

        JLabel textLabel = new JLabel("The Knight's Adventure");
        textLabel.setFont(font);
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(350, -100, 900, 400);
        backgroundLabel.add(textLabel);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.start();
                level.playMusicBackground();
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

    public void updateLevel(GameLevel level) {
        this.level = level;
    }
}
