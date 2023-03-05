package game;
import city.cs.engine.*;

import java.awt.*;
import javax.swing.*;

public class GameView extends UserView {
    private Image background1;

    public GameView(GameWorld world, int width, int height) {
        super(world, width, height);
        this.background1 = new ImageIcon("data/Background.png").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background1, 0, 0, this);
    }
/*
    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawImage(background2, 0, 0, this);
    }*/
}

