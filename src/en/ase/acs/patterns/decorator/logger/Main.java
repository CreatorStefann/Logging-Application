// DEMO PURPOSE ONLY !!!!!
package en.ase.acs.patterns.decorator.logger;

public class Main {
    public static void main(String[] args) {
        BasicErrorLogger core = new BasicErrorLogger();

        ILogger fancy =
                new ThreadIdDecorator(
                        new LevelDecorator(
                                new TimestampDecorator(core),
                                "INFO"));

        fancy.log("Database connection failed!");
    }
}
