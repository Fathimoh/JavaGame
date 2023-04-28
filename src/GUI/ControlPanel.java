package GUI;

import GameLevels.GameLevel;
import game.GameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel {
    private GameLevel level;
    private JButton playButton;
    public JPanel mainPanel;
    private JButton quitButton;
    private JButton instructionsButton;


    public ControlPanel(JFrame frame, GameLevel level, GameView view){
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

        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void updateLevel(GameLevel level){
        this.level = level;
    }
}
