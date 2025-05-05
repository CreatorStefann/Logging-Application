package en.ase.acs.patterns.adapter;

import en.ase.acs.patterns.adapter.abstracts.ILegacyLogger;
import en.ase.acs.patterns.decorator.logger.ILogger;

public class Logger2LegacyAdapter implements ILegacyLogger {
    private final ILogger reference;
    private boolean enabled = true;
    private static final int LIMIT = 1024;

    public Logger2LegacyAdapter(ILogger reference) {
        this.reference = reference;
    }

    @Override public void logTheError(String[] log) {
        if(enabled) reference.log(String.join(" ", log));
    }
    @Override public void setTheLoggingState(boolean state) { enabled = state; }
    @Override public int  computeTheLogSize(String[] log)   { return String.join(" ", log).length(); }
    @Override public boolean isItTooBig(int size)          { return size > LIMIT; }
}
