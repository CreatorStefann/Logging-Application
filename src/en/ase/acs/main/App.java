package en.ase.acs.main;

import en.ase.acs.patterns.decorator.logger.*;
import en.ase.acs.patterns.adapter.concretes.LegacyLogger;
import en.ase.acs.patterns.adapter.Legacy2LoggerAdapter;
import en.ase.acs.patterns.adapter.Logger2LegacyAdapter;

public class App {
    public static void main(String[] args) {

        // New logger wrapped with a few decorators
        ILogger logger = new ThreadIdDecorator(
                new LevelDecorator(
                        new TimestampDecorator(
                                new BasicErrorLogger()
                        ), "INFO"));

        logger.log("First test message.");

        // Send a message through the old logger via adapter
        LegacyLogger legacy = new LegacyLogger();
        ILogger throughLegacy = new Legacy2LoggerAdapter(legacy);
        throughLegacy.log("This one uses the legacy logger underneath.");

        // Let legacy‑only code use the new logger
        Logger2LegacyAdapter legacyClient = new Logger2LegacyAdapter(logger);
        legacyClient.logTheError(new String[] { "Old", "code", "calling", "new", "logger" });
    }
}
