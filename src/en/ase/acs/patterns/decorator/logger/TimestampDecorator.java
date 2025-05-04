package en.ase.acs.patterns.decorator.logger;

import java.time.LocalDateTime;

public class TimestampDecorator extends ALoggerDecorator {

    public TimestampDecorator(ILogger reference) {
        super(reference);
    }

    @Override
    public void log(String message) {
        System.out.println("Timestamp: " + LocalDateTime.now());
        reference.log(message);
    }
}
