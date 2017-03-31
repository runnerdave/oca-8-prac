import java.util.concurrent.*;
import static java.util.concurrent.TimeUnit.*;

public class ExecutorsPrac {
    public static void main(String... args) {
        ExecutorsPrac ep = new ExecutorsPrac();
        ep.beepForAWhile();

        
    }

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void beepForAWhile() {
        final Runnable beeper = new Runnable() {
            public void run() { System.out.println("beep"); }
        };

        final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 10, 10, SECONDS);

        scheduler.schedule(new Runnable() {
                                public void run() { beeperHandle.cancel(true); }
                                }, 60, SECONDS);

    }
}