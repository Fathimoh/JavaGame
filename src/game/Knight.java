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

    private int coins = 0;
    private int SkeletonCounter = 0;
    private int health = 5;


    public Knight(World world){
        super(world, KnightShape);
        addImage(image);
        coins = 0;
        //this.setAlwaysOutline(true);
    }

    public void DecreaseHealth(){
        health -= 1;
        System.out.println("Health - 1 and is now "+ health);
        if(health <= 0){
            System.out.println("Game over");
        }
    }

    public void setCoins(int coins){
        this.coins = coins;
        System.out.println("Coins = " + coins);
    }

    public int getCoins(){
        return coins;
    }

    public void addCoins(){
        setCoins(getCoins() +1);
    }

    public int getSkeletons(){
        return SkeletonCounter;
    };
    public void setSkeleton(int SkeletonCounter){
        this.SkeletonCounter = SkeletonCounter;
        System.out.println("Skeletons = " + SkeletonCounter);
    }
}


/*what's left:
- stats on foreground
- Collisions with skeleton
 */
