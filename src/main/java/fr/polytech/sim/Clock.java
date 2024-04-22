package fr.polytech.sim;

import java.util.Random;

/**
 * A clock used to synchronize simulations.
 */
public class Clock {
    private final int time = new Random().nextInt(25);

    // Instance de clock, qui correspond à notre singleton
    private static final Clock instance = new Clock();

    // Constructeur privé pour garantir l'instance unique en empêchant les nouvelles instanciations
    private Clock() {
    }
    /**
     * Random integer between 0 and 24 inclusive.
     */
    public int getTime() {
        return this.time;
    }

    // Retourne l'unique instance de Clock.
    public static Clock getInstance() {
        return instance;
    }
}
