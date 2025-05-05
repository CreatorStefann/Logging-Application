package en.ase.acs.patterns.decorator.logger;

import en.ase.acs.patterns.decorator.interfaces.ILogger;

public class BasicErrorLogger implements ILogger {
    public String prefix = "ERROR";

    @Override
    public void log(String message) {
        System.out.println(prefix + ": " + message);
    }
}
