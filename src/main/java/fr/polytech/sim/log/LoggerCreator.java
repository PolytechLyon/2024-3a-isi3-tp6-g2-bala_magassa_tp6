package fr.polytech.sim.log;

// Fabrique à Logger, qui crée des objets de type Logger
public class LoggerCreator {


    // Méthode de fabrique, qui renvoie un Produit (Logger)
    static public Logger factoryMethod(String className) {
        return new FileLogger(className);
    }

}
