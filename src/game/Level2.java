package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public class Level2 extends GameLevel {

    public Level2(Game game) {
        super(game);
        getKnight().setPosition(new Vec2(-34, -13));
        getKnight().setGravityScale(2f);

        Shape PlatformShape = new BoxShape(3f, 0.5f);
        Shape groundPlatform = new BoxShape(40, 0.5f);

        // Make a ground platform//
        Platform platformG = new Platform(this, groundPlatform, 0f,-15f, "ground");
    }

    @Override
    public boolean isComplete() {
        if (getKnight().getCoins() == 6)
            return true;
        else return false;
    }

}
