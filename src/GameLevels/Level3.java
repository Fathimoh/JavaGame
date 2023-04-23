package GameLevels;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import game.Game;
import Objects.Platform;
import org.jbox2d.common.Vec2;

public class Level3 extends GameLevel {

    public Level3(Game game) {
        super(game);
        getKnight().setPosition(new Vec2(-34, -13));
        Shape PlatformShape = new BoxShape(3f, 0.5f);
        Shape groundPlatform = new BoxShape(40, 0.5f);

        //make platforms//
        Platform platform1 = new Platform(this, PlatformShape, -23f,-14f);
        Platform platform2 = new Platform(this, PlatformShape, -19f,-13f);

        //make ground platform//
        Platform platformG = new Platform(this, groundPlatform, 0f,-15f, "ground");


        //make coins//


        //make skeletons//
    }

    @Override
    public boolean isComplete() {
        return false;
    }
}
