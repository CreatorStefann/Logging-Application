package en.ase.acs.main;

import en.ase.acs.patterns.adapter.Legacy2LoggerAdapter;
import en.ase.acs.patterns.adapter.Logger2LegacyAdapter;
import en.ase.acs.patterns.adapter.concretes.LegacyLogger;
import en.ase.acs.patterns.decorator.LevelDecorator;
import en.ase.acs.patterns.decorator.ThreadIdDecorator;
import en.ase.acs.patterns.decorator.TimestampDecorator;
import en.ase.acs.patterns.decorator.interfaces.ILogger;
import en.ase.acs.patterns.decorator.logger.*;

import java.util.Scanner;

public class MyThread extends Thread{
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select a logging option:");
            System.out.println("1) Basic Error Logger");
            System.out.println("2) Timestamp Decorator");
            System.out.println("3) Level Decorator");
            System.out.println("4) Thread-ID Decorator");
            System.out.println("5) Combined (Timestamp + Level + Thread-ID)");
            System.out.println("6) Legacy Logger via Adapter");
            System.out.println("7) Legacy client using new logger via Adapter");
            System.out.println("8) Exit");
            System.out.print("Enter choice (1-8): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 8.\n");
                continue;
            }

            if (choice == 8) {
                System.out.println("Exiting. Goodbye!");
                break;
            }

            System.out.print("Enter your log message: ");
            String message = scanner.nextLine();
            ILogger logger;
            switch (choice) {
                case 1:
                    logger = new BasicErrorLogger();
                    logger.log(message);
                    break;
                case 2:
                    logger = new TimestampDecorator(new BasicErrorLogger());
                    logger.log(message);
                    break;
                case 3:
                    logger = new LevelDecorator(new BasicErrorLogger(), "INFO");
                    logger.log(message);
                    break;
                case 4:
                    logger = new ThreadIdDecorator(new BasicErrorLogger());
                    logger.log(message);
                    break;
                case 5:
                    logger = new ThreadIdDecorator(
                            new LevelDecorator(
                                    new TimestampDecorator(
                                            new BasicErrorLogger()
                                    ), "DEBUG"
                            )
                    );
                    logger.log(message);
                    break;
                case 6:
                    LegacyLogger legacy = new LegacyLogger();
                    ILogger adapted = new Legacy2LoggerAdapter(legacy);
                    adapted.log(message);
                    break;
                case 7:
                    // Use new logger (with decorators) via Logger2LegacyAdapter
                    ILogger base = new ThreadIdDecorator(
                            new LevelDecorator(
                                    new TimestampDecorator(
                                            new BasicErrorLogger()
                                    ), "WARN"
                            )
                    );
                    Logger2LegacyAdapter legacyClient = new Logger2LegacyAdapter(base);
                    legacyClient.logTheError(message.split(" "));
                    break;
                default:
                    System.out.println("Choice out of range. Please try again.\n");
            }

            System.out.println();
        }
        scanner.close();
    }
}
