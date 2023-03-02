package game;

import city.cs.engine.*;

public class Knight extends DynamicBody {
    private static final Shape KnightShape = new BoxShape(1,2);

    private static final BodyImage image = new BodyImage("data/Freeknight/MC/Gifs/_Idle.gif", 4f);

    public Knight(World world){
        super(world, KnightShape);
        addImage(image);

    }
}
