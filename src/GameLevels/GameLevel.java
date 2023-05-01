package GameLevels;

import city.cs.engine.World;
import game.Game;
import game.GameView;
import game.Knight;

public abstract class GameLevel extends World {
    private Knight knight;
    public GameLevel(Game game){
        super(60);
        knight = new Knight(this);
    }
    public Knight getKnight(){
        return knight;
    }


    public abstract boolean isComplete();

    public abstract void playMusicBackground();

    public abstract void endMusicBackground();

    public abstract void updateView(GameView view);
}
