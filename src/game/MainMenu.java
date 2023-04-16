package game;
import javax.swing.*;

public class MainMenu {
    public MainMenu(){
        JFrame window = new JFrame("Main Menu");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ControlPanel controlPanel = new ControlPanel();
        window.add(controlPanel.mainPanel);

        window.pack();
        window.setVisible(true);
    }

    public static void main(String[] args) {

    }
}
