package fr.polytech.sim.log;

/**
 * Name logger that is supposed to log its name along with each log entry, to
 * facilitate tracing.
 */
abstract class NamedLogger implements Logger {
    final protected String name;

    /**
     * Constructor.
     *
     * @param name  logger name.
     */
    protected NamedLogger(String name) {
        this.name = name;
    }

    // Opération spécifique à implémenter dans les classes filles
    public abstract void operationLog(String message);

    // Template method qui factorise les étapes communes au FileLogger et au ConsoleLogger
    // Et appelle ensuite la méthode
    @Override
    synchronized public void log(String format, Object... args) {
        String entry = String.format(format, args);
        String message = String.format("%s\t%s\n", this.name, entry);
        operationLog(message);
    }
}
