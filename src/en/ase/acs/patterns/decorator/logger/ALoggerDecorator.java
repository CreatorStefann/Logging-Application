package en.ase.acs.patterns.decorator.logger;

public abstract class ALoggerDecorator implements ILogger {
    protected ILogger reference;

    public ALoggerDecorator(ILogger reference) {
        this.reference = reference;
    }
}
