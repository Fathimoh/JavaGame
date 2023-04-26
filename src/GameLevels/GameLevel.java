package GameLevels;


import Objects.JumpPad;
import city.cs.engine.World;
import game.Game;
import game.Knight;
import game.KnightController;
import game.Slash;

public abstract class GameLevel extends World {
    private Knight knight;
    private KnightController controller;
    public GameLevel(Game game){
        super(60);
        knight = new Knight(this);
    }
    public Knight getKnight(){
        return knight;
    }

    public KnightController getController() {
        return controller;
    }

    public abstract boolean isComplete();

    public abstract void endMusicBackground();
}
