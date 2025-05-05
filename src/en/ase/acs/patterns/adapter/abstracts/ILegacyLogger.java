package en.ase.acs.patterns.adapter.abstracts;

public interface ILegacyLogger {
    void logTheError(String[] log);
    void setTheLoggingState(boolean state);
    int  computeTheLogSize(String[] log);
    boolean isItTooBig(int size);
}
