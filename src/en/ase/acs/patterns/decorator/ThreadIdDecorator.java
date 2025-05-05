package en.ase.acs.patterns.decorator;

import en.ase.acs.patterns.decorator.interfaces.ILogger;

public class ThreadIdDecorator extends ALoggerDecorator {

    public ThreadIdDecorator(ILogger reference) {
        super(reference);
    }

    @Override
    public void log(String message) {
        System.out.println("Thread: " + Thread.currentThread().getName());
        reference.log(message);
    }
}
