package fr.polytech.sim.cycling;

import fr.polytech.sim.cycling.SimpleBike;
import fr.polytech.sim.transport.Wheel;

public class TagAlongBike extends SimpleBike{

    /**
     * Constructor.
     */
    public TagAlongBike() {
        components.add(new SimpleBike());
    }

}
