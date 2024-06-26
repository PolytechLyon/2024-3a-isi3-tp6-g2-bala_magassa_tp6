package fr.polytech.sim.transport;

import fr.polytech.sim.Clock;
import fr.polytech.sim.cycling.Bike;
import fr.polytech.sim.log.Logger;
import fr.polytech.sim.log.LoggerCreator;
import fr.polytech.sim.log.TimestampedLoggerDecorator;

import java.util.Objects;

/**
 * A wheel that can be used with different vehicle types.
 */
public class Wheel implements MobileObject {
    private static final double DEFAULT_MASSE = 10;

    private final Logger basicLogger = LoggerCreator.factoryMethod(this.getClass().toString());
    private final TimestampedLoggerDecorator logger = new TimestampedLoggerDecorator(basicLogger);
    private final Clock clock = Clock.getInstance();
    private final Bike drive;

    /**
     * Constructor.
     *
     * @param drive  the object providing push power.
     */
    public Wheel(Bike drive) {
        Objects.requireNonNull(drive, "Bike must not be null.");
        this.drive = drive;
    }

    @Override
    public double getVelocity() {
        final double acceleration = this.drive.getPush() / this.getMass();
        final int time = this.clock.getTime();
        double velocity = time * acceleration;
        this.logger.log("%s", "Velocity " + velocity + " Km/h at " + time + " s.");
        return velocity;
    }

    @Override
    public double getMass() {
        return DEFAULT_MASSE;
    }
}
