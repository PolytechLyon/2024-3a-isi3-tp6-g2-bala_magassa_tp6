package fr.polytech.sim.cycling;

public class TagAlongBike extends SimpleBike {

    /**
     * Constructor.
     */
    public TagAlongBike() {
        components.add(new SimpleBike());
    }

}
