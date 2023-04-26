package game;

import city.cs.engine.*;

public class Knight extends Walker {
    private static final Shape KnightShape = new PolygonShape(
            -0.05f,2.0f,
            -1.11f,0.69f,
            -0.89f,-1.97f,
            0.99f,-1.98f,
            1.09f,-0.59f,
            0.7f,1.63f,
            0.37f,1.97f);

    private static final BodyImage image = new BodyImage("data/IdleRight.gif", 4f);

    private int coins;
    private int SkeletonCounter = 0;
    private int BeetleCounter = 0;
    private int VultureCounter = 0;
    private int health = 3;


    public Knight(World world){
        super(world, KnightShape);
        addImage(image);
        this.setGravityScale(2f);
        //this.setAlwaysOutline(true);
    }

    public void DecreaseKnightHealth(){
        health -= 1;
    }

    public int getHealth(){
        return health;
    }

    public int getCoins(){
        return coins;
    }

    public void addCoins(){
        coins ++;
    }

    public void setCoins(int coins){
        this.coins = coins;
    }

    public int getSkeletons(){
        return SkeletonCounter;
    }
    public void setSkeleton(int SkeletonCounter){
        this.SkeletonCounter = SkeletonCounter;
    }
    public int getBeetle(){
        return BeetleCounter;
    }
    public void setBeetle(int BeetleCounter){
        this.BeetleCounter = BeetleCounter;
    }
    public void setVulture(int VultureCounter){
        this.VultureCounter = VultureCounter;
    }
    public int getVulture(){
        return VultureCounter;
    }
}

/*what's left:
- projectiles need to disappear after a certain amount of time / Use of timers
- Game over screen

 */
