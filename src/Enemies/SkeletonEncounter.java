package Enemies;

import game.Game;
import game.Knight;

/**
 * @author Fathi, Mohamed, Fathi.Mohamed@city.ac.uk
 */
public class SkeletonEncounter extends MobsEncounter {
    /**
     * used for collision detection between the enemy and the skeleton
     * @param k takes in the knight so it can be detected
     * @param g takes in the game so it can also know the collsions that happen
     */
    public SkeletonEncounter(Knight k, Game g) {
        super(k, g);
    }
}