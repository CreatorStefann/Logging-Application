package en.ase.acs.patterns.decorator.logger;

public class BasicErrorLogger implements ILogger {
    public String prefix = "ERROR";

    @Override
    public void log(String message) {
        System.out.println(prefix + ": " + message);
    }
}
