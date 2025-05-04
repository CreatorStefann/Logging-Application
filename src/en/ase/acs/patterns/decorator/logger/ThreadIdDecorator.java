package en.ase.acs.patterns.decorator.logger;

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
