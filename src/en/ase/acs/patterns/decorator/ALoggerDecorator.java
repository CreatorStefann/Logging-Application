package en.ase.acs.patterns.decorator;

import en.ase.acs.patterns.decorator.interfaces.ILogger;

public abstract class ALoggerDecorator implements ILogger {
    protected ILogger reference;

    public ALoggerDecorator(ILogger reference) {
        this.reference = reference;
    }
}
