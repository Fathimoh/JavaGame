package game;


import city.cs.engine.World;

public abstract class GameLevel extends World {
    private Knight knight;
    public GameLevel(Game game){
        super(60);
        knight = new Knight(this);
        getKnight().setGravityScale(2f);
    }

    public Knight getKnight(){
        return knight;
    }

    public abstract boolean isComplete();
}
