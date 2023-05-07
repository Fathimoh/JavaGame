package Enemies;

import game.Game;
import game.Knight;

/**
 * @author Fathi, Mohamed, Fathi.Mohamed@city.ac.uk
 */
public class BeetleEncounter extends MobsEncounter {
    /**
     * used for collision detection between the enemy and the beetle
     * @param k takes in the knight so it can be detected
     * @param g takes in the game so it can also know the collsions that happen
     */
    public BeetleEncounter(Knight k, Game g) {
        super(k, g);
    }
}
