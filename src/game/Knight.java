package game;

import city.cs.engine.*;

/**
 * @author Fathi, Mohamed, Fathi.Mohamed@city.ac.uk
 */
public class Knight extends Walker {
    /**
     * used to make the hit box/outline of the knight
     */
    private static final Shape KnightShape = new PolygonShape(
            -0.05f,2.0f,
            -1.11f,0.69f,
            -0.89f,-1.97f,
            0.99f,-1.98f,
            1.09f,-0.59f,
            0.7f,1.63f,
            0.37f,1.97f);
    /**
     * adds image of the knight onto the shape
     */
    private static final BodyImage image = new BodyImage("data/IdleRight.gif", 4f);
    /**
     * variables used to keep track of stats
     */
    private int coins;
    private int SkeletonCounter = 0;
    private int BeetleCounter = 0;
    private int VultureCounter = 0;
    private int health = 3;

    /**
     * constructor used to initialise the knight to a solid fixure and also add the image to the world
     * @param world adds the knight to the world
     */
    public Knight(World world){
        super(world, KnightShape);
        addImage(image);
        this.setGravityScale(2f);
        SolidFixture fixture = new SolidFixture(this, KnightShape);
        fixture.setFriction(0);
    }
    /**
     * method used to decrement the knight health by 1
     */
    public void DecreaseKnightHealth(){
        health -= 1;
    }
    /**
     * method used to get the players health
     * @return the knights health
     */
    public int getHealth(){
        return health;
    }
    /**
     * method used to get the coins
     * @return the amount of coins collected
     */
    public int getCoins(){
        return coins;
    }
    /**
     * method used to increment the coin count variable by 1 each time a coin is collected
     */
    public void addCoins(){
        coins ++;
    }
    /**
     * method that sets the coins to 0
     * @param coins used to take in the coin count (stats)
     */
    public void setCoins(int coins){
        this.coins = coins;
    }
    /**
     * method used to get the skeleton
     * @return the skeleton counter to see how much skeletons have been killed
     */
    public int getSkeletons(){
        return SkeletonCounter;
    }
    /**
     * method that sets the skeleton counter/updates the counter so its functioning
     * @param SkeletonCounter used to take in the amount of skeletons that have been slayed
     */
    public void setSkeleton(int SkeletonCounter){
        this.SkeletonCounter = SkeletonCounter;
    }
    /**
     * method used to get the number of beetles
     * @return used to retrieve the amount of beetles that have been slayed
     */
    public int getBeetle(){
        return BeetleCounter;
    }
    /**
     * method used to set the beetle counter/update the beetle counter so its functioning
     * @param BeetleCounter used to retrieve the amount of bettles that have been slayed by the knight
     */
    public void setBeetle(int BeetleCounter){
        this.BeetleCounter = BeetleCounter;
    }
    /**
     * method used to set the vulture count so its functioning
     * @param VultureCounter retrieves the amount of vultures that have been slayed by the knight
     */
    public void setVulture(int VultureCounter){
        this.VultureCounter = VultureCounter;
    }
    /**
     * method used to get the vulture
     * @return the amount of vultures killed
     */
    public int getVulture(){
        return VultureCounter;
    }
}

