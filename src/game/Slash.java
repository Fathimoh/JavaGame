package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Slash extends DynamicBody {

    //private static Shape shape = new BoxShape(1f,1f);
    private static BodyImage imageRight = new BodyImage("data/ProjectileSlashRight.png", 3f);
    private static BodyImage imageLeft = new BodyImage("data/ProjectileSlashLeft.png", 3f);

    private final Knight knight;

    private final KnightController controller;
    private final int projectileSpeed = 20;


    public Slash(World world, Knight knight, KnightController controller) {
        super(world);
        //addImage(imageLeft);
        //addImage(imageRight);
        this.knight = knight;
        this.controller = controller;
        //this.setAlwaysOutline(true);
    }

    public void hit(){
        DynamicBody projectile = new DynamicBody(knight.getWorld(), new BoxShape(1f, 1f));
        ProjectileImpact impact = new ProjectileImpact(knight);
        projectile.addCollisionListener(impact);
        System.out.println("left: "+ controller.isLeft() + " right: " + controller.isRight());

        if(controller.isRight()){
            projectile.setPosition(new Vec2(knight.getPosition().x+3, knight.getPosition().y));
            projectile.setLinearVelocity(new Vec2(projectileSpeed, 0));
            projectile.addImage(imageRight);
        } if(controller.isLeft()){
            projectile.setPosition(new Vec2(knight.getPosition().x-3, knight.getPosition().y));
            projectile.setLinearVelocity(new Vec2(-projectileSpeed, 0));
            projectile.addImage(imageLeft);
        }
    }
}
//i need ikik


