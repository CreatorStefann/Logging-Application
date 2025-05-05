package en.ase.acs.patterns.decorator;

import en.ase.acs.patterns.decorator.interfaces.ILogger;

public class LevelDecorator extends ALoggerDecorator {
    private final String level;

    public LevelDecorator(ILogger reference, String level) {
        super(reference);
        this.level = level;
    }

    @Override
    public void log(String message) {
        System.out.println("Level: " + level);
        reference.log(message);
    }
}
