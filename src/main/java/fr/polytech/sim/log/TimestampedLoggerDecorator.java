package fr.polytech.sim.log;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimestampedLoggerDecorator extends LoggerDecorator {

    private Logger component;

    public TimestampedLoggerDecorator(Logger component, String name) {
        super(name);
        this.component = component;
    }

    @Override
    public void log(String format, Object... args) {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        // On décore le message du log en y ajoutant la date et l'heure
        component.log(String.format("[%s] - %s", date, String.format("%s", args)));
    }
}
