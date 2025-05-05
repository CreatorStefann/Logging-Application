package en.ase.acs.patterns.adapter.concretes;

import en.ase.acs.patterns.adapter.abstracts.ILegacyLogger;

public class LegacyLogger implements ILegacyLogger {
    private boolean enabled = true;
    private static final int LIMIT = 1024;

    @Override public void logTheError(String[] log) {
        if(enabled) System.out.println("[LEGACY] " + String.join(" ", log));
    }
    @Override public void setTheLoggingState(boolean state) { enabled = state; }
    @Override public int  computeTheLogSize(String[] log)   { return String.join(" ", log).length(); }
    @Override public boolean isItTooBig(int size)          { return size > LIMIT; }
}
