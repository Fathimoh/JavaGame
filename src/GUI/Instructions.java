package GUI;

import GameLevels.GameLevel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;

public class Instructions {
    private JButton backButton;
    private JPanel mainPanel;
    private JFrame frame;
    private ControlPanel controlPanel;
    private GameLevel level;

    public Instructions(JFrame frame, ControlPanel controlPanel){
        Font buttonFont;
        try{
            //Calls out the font file saved in data//
            InputStream f = new FileInputStream("data/PixelFont.ttf");
            buttonFont = Font.createFont(Font.TRUETYPE_FONT, f).deriveFont(Font.BOLD, 15f);
        } catch (Exception e){
            //when an error happens and the file is not read then the font will change to arial//
            System.err.println("failed to load file" + e.getMessage());
            buttonFont = new Font("Arial", Font.BOLD, 30);
        }

        this.frame = frame;
        this.controlPanel = controlPanel;

        JLabel backgroundLabel = new JLabel(new ImageIcon("data/Instructions.jpg"));
        backgroundLabel.setBounds(0, 0, 1424, 650);
        mainPanel.setLayout(new OverlayLayout(mainPanel));
        mainPanel.add(backgroundLabel);

        backButton.setBounds(1300, 3, 100, 40);
        backgroundLabel.add(backButton);
        backButton.setFont(buttonFont);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                frame.add(mainPanel);
                controlPanel.getMainPanel().setVisible(true);
                frame.add(controlPanel.getMainPanel());
            }
        });
    }
    public JPanel getMainPanel(){
        return mainPanel;
    }
}
