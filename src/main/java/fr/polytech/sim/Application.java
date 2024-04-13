package fr.polytech.sim;

import fr.polytech.sim.cycling.BikeSimulator;
import fr.polytech.sim.cycling.SimpleBike;
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

        System.out.println("Lancement de la simulation dans le fichier de logs...");
        new BikeSimulator().run();

        System.out.println("Test des fonctions getVelocity et getMass de la classe TagAlongBike :");
        TagAlongBike tagAlongBike = new TagAlongBike();
        System.out.println("Velocité de tagAlongBike : " + tagAlongBike.getVelocity());
        System.out.println("Masse de tagAlongBike : " + tagAlongBike.getMass());

        System.out.println("Test des fonctions getVelocity et getMass de la classe SimpleBike :");
        SimpleBike simpleBike = new SimpleBike();
        System.out.println("Velocité de simpleBike : " + simpleBike.getVelocity());
        System.out.println("Masse de simpleBike : " + simpleBike.getMass());
    }
}
