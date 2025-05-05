package en.ase.acs.patterns.adapter;

import en.ase.acs.patterns.adapter.abstracts.ILegacyLogger;
import en.ase.acs.patterns.decorator.logger.ILogger;

public class Legacy2LoggerAdapter implements ILogger {
    private final ILegacyLogger reference;

    public Legacy2LoggerAdapter(ILegacyLogger reference) {
        this.reference = reference;
    }

    @Override public void log(String message) {
        reference.logTheError(message.split(" "));
    }
}
