package fr.polytech.sim.log;

/**
 * No-op logger.
 */
class NoopLogger implements Logger {

    public void log(String format, Object... args) {
        // Do nothing
    }
}
