package fr.polytech.sim.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampedLoggerDecorator extends LoggerDecorator {

    private Logger component;

    public TimestampedLoggerDecorator(Logger component, String name) {
        super(name);
        this.component = component;
    }


    @Override
    public void log(String format, Object... args) {
        component.log(format, args);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        component.log(dtf.format(LocalDateTime.now()));
    }
}
