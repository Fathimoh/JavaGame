package game;

import GameLevels.GameLevel;
import GameLevels.Level1;
import GameLevels.Level2;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Slash extends DynamicBody {

    private static final BodyImage NormalSlashRight = new BodyImage("data/ProjectileSlashRight.png", 3f);
    private static final BodyImage FlameSlashRight = new BodyImage("data/ProjectileFlameSlashRight.png", 3f);
    private static final BodyImage NormalSlashLeft = new BodyImage("data/ProjectileSlashLeft.png", 3f);
    private static final BodyImage FlameSlashLeft = new BodyImage("data/ProjectileFlameSlashLeft.png", 3f);

    private final Shape shape = new BoxShape(0.8f, 1.4f);

    private Knight knight;

    private KnightController controller;

    private GameLevel level;

    public Slash(World world, Knight knight, String direction) {
        super(world);
        this.knight = knight;

        Fixture GhostlyFixture = new GhostlyFixture(this, shape);
        Sensor senor = new ProjectileSensor(this, shape, knight);

        int projectileSpeed = 20;
        this.setGravityScale(0);
        if (direction.equals("right")) {
            if (knight.getWorld() instanceof Level1) {
                this.addImage(NormalSlashRight);
            } else if (knight.getWorld() instanceof Level2) {
                this.addImage(FlameSlashRight);
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
            this.setPosition(new Vec2(knight.getPosition().x - 3, knight.getPosition().y));
            this.setLinearVelocity(new Vec2(-projectileSpeed, 0));
        }
    }

    public void updateKnight(Knight knight){
        this.knight = knight;
    }
    public KnightController getController() {
        return controller;
    }
}


