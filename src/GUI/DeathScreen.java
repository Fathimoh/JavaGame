package GUI;

import GameLevels.GameLevel;
import game.Game;
import game.GameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeathScreen {
    private GameLevel level;
    private JButton playAgainButton;
    public JPanel mainPanel;
    private JButton quitButton;

    public DeathScreen(JFrame frame, GameLevel level, GameView view, Game game){
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.restartLevel();
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
