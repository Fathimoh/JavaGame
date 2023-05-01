package Objects;

import city.cs.engine.*;

public class Coins extends DynamicBody {
    private static final Shape coinShape = new BoxShape(0.8f,0.8f);
    private static final BodyImage image =
            new BodyImage("data/Coin.gif", 1.5f);

    public Coins(World world) {
        super(world, coinShape);
        addImage(image);
    }
}
