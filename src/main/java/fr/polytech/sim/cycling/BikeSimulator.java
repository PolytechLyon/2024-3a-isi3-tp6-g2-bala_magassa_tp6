package fr.polytech.sim.cycling;

import fr.polytech.sim.Simulation;
import fr.polytech.sim.log.Logger;
import fr.polytech.sim.log.LoggerCreator;
import fr.polytech.sim.utils.Context;

import java.util.Iterator;

/**
 * Bike simulation.
 */
public class BikeSimulator implements Simulation {
    private final Logger logger = LoggerCreator.factoryMethod(this.getClass().toString());

    public void run() {
        this.logger.log("[SIMULATION] Lancement de la simulation avec les différentes instances de vélos disponibles : ");

        // Récupération de toutes les instances de Bike
        Iterator<Bike> bikesIterator = Context.injectAll(Bike.class);
        while (bikesIterator.hasNext()) {
            Bike bike = bikesIterator.next();
            this.logger.log("[SIMULATION] Instance de " + bike.getClass() + " : ");
            this.logger.log("[SIMULATION] Bike's speed %.2f Km/h.", bike.getVelocity());
            this.logger.log("[SIMULATION] Bike's mass %.2f Kg.", bike.getMass());
            this.logger.log(" ");
        }
    }
}