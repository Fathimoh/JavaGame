package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Slash extends DynamicBody {

    private static final BodyImage imageRight = new BodyImage("data/ProjectileSlashRight.png", 3f);
    private static final BodyImage imageLeft = new BodyImage("data/ProjectileSlashLeft.png", 3f);

    private Knight knight;

    private final KnightController controller;

    private DynamicBody projectile;


    public Slash(World world, Knight knight, KnightController controller) {
        super(world);
        this.knight = knight;
        this.controller = controller;
    }

    public void hit(){
        int projectileSpeed = 20;
        projectile = new DynamicBody(knight.getWorld(), new BoxShape(0.8f, 1.4f));
        ProjectileImpact impact = new ProjectileImpact(knight);
        projectile.addCollisionListener(impact);

        if(controller.isRight()){
            projectile.setGravityScale(0);
            projectile.setPosition(new Vec2(knight.getPosition().x+3, knight.getPosition().y));
            projectile.setLinearVelocity(new Vec2(projectileSpeed, 0));
            projectile.addImage(imageRight);
        } if(controller.isLeft()){
            projectile.setGravityScale(0);
            projectile.setPosition(new Vec2(knight.getPosition().x-3, knight.getPosition().y));
            projectile.setLinearVelocity(new Vec2(-projectileSpeed, 0));
            projectile.addImage(imageLeft);
        }
        //projectile.setAlwaysOutline(true);

    }

    public void updateKnight(Knight knight){
        this.knight = knight;
    }
}


