package fr.polytech.sim;

import fr.polytech.sim.cycling.BikeSimulator;
import fr.polytech.sim.cycling.TagAlongBike;

/**
 * Application's main classe.
 */
public class Application {

    /**
     * Entry point.
     * @param args  app's arguments.
     */
    public static void main(String... args) {
        new BikeSimulator().run();

        // Test des fonctions getVelocity et getMass de la classe TagAlongBike
        TagAlongBike tagAlongBike = new TagAlongBike();
        System.out.println("Velocité de tagAlongBike : " + tagAlongBike.getVelocity());    
        System.out.println("Masse de tagAlongBike : " + tagAlongBike.getMass());    
    }
}
