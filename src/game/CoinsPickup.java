package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class CoinsPickup implements CollisionListener {
    private final Knight knight;

    public CoinsPickup(Knight k) {
        knight = k;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Coins) {
            knight.addCoins();
            collisionEvent.getOtherBody().destroy(); //removes the coins//
        }
    }
}
