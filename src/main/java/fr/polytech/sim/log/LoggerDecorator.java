package fr.polytech.sim.log;

public abstract class LoggerDecorator implements Logger {

    final protected String name;

    public LoggerDecorator(String name) {
        super();

        this.name = name;
    }
}
