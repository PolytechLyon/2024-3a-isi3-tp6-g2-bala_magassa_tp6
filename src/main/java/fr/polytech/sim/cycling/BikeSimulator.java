package fr.polytech.sim.cycling;

import fr.polytech.sim.Simulation;
import fr.polytech.sim.log.Logger;
import fr.polytech.sim.log.LoggerCreator;
import fr.polytech.sim.utils.Context;

/**
 * Bike simulation.
 */
public class BikeSimulator implements Simulation {
    private final Logger logger = LoggerCreator.factoryMethod(this.getClass().toString());

    public void run() {

        // Injection d'une instance de Bike par le contexte applicatif
        Context context = new Context();
        Bike bike = context.inject(Bike.class);

        this.logger.log("\n[SIMULATION] Lancement de la simulation avec une instance de " + bike.getClass() + " : ");
        this.logger.log("[SIMULATION] Bike's speed %.2f Km/h.", bike.getVelocity());
        this.logger.log("[SIMULATION] Bike's mass %.2f Kg.", bike.getMass());
    }
}
