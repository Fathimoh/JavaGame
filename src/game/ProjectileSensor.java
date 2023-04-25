package game;

import city.cs.engine.Body;
import city.cs.engine.Sensor;
import city.cs.engine.Shape;

public class ProjectileSensor extends Sensor {
    public ProjectileSensor(Slash slash, Shape shape, Knight knight) {
        super(slash, shape);
        ProjectileSensorListener projectileSensorListener = new ProjectileSensorListener(slash, knight);
        this.addSensorListener(projectileSensorListener);
    }
}
