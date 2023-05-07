package game;

import GameLevels.Level1;
import GameLevels.Level2;
import GameLevels.Level3;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * @author Fathi, Mohamed, Fathi.Mohamed@city.ac.uk
 */
public class Slash extends DynamicBody {
    /**
     * fields that have different images of projectile slashes
     * Each projectile is used in different levels
     */

    private static final BodyImage NormalSlashRight = new BodyImage("data/ProjectileSlashRight.png", 3f);
    private static final BodyImage FlameSlashRight = new BodyImage("data/ProjectileFlameSlashRight.png", 3f);
    private static final BodyImage NormalSlashLeft = new BodyImage("data/ProjectileSlashLeft.png", 3f);
    private static final BodyImage FlameSlashLeft = new BodyImage("data/ProjectileFlameSlashLeft.png", 3f);
    private static final BodyImage WaterSlashRight = new BodyImage("data/ProjectileWaterSlashRight.png", 3f);
    private static final BodyImage WaterSlashLeft = new BodyImage("data/ProjectileWaterSlashLeft.png", 3f);

    /**
     * method used to create the functionality of the slash projectile
     * this method will have many features such how fast the slash will move, the force acting against the slash, the distance it will start from...
     * @param world used to display the slash into the world
     * @param knight used to display the slash from the knight into the world (knight used to slash positioning)
     * @param direction used to figure out which direction the slash is going in
     */
    public Slash(World world, Knight knight, String direction) {
        super(world);
        Shape shape = new BoxShape(0.8f, 1.4f);
        new GhostlyFixture(this, shape);
        new ProjectileSensor(this, shape, knight);

        int projectileSpeed = 20;
        this.setGravityScale(0);
        if (direction.equals("right")) {
            if (knight.getWorld() instanceof Level1) {
                this.addImage(NormalSlashRight);
            } else if (knight.getWorld() instanceof Level2) {
                this.addImage(FlameSlashRight);
            } else if(knight.getWorld() instanceof Level3){
                this.addImage(WaterSlashRight);
            }
            this.setPosition(new Vec2(knight.getPosition().x + 3, knight.getPosition().y));
            this.setLinearVelocity(new Vec2(projectileSpeed, 0));
        } else if (direction.equals("left")) {
            if (knight.getWorld() instanceof Level1) {
                this.addImage(NormalSlashLeft);
            }
            if (knight.getWorld() instanceof Level2) {
                this.addImage(FlameSlashLeft);
            }
            if (knight.getWorld() instanceof Level3){
                this.addImage(WaterSlashLeft);
            }
            this.setPosition(new Vec2(knight.getPosition().x - 3, knight.getPosition().y));
            this.setLinearVelocity(new Vec2(-projectileSpeed, 0));
        }
    }
}


