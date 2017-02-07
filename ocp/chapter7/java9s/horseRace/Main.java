import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
* from: http://codereview.stackexchange.com/questions/36806/multithreaded-horse-race-simulation
* the review has not been implemented
*/

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        ExecutorService e = Executors.newFixedThreadPool(10);
        FinishingLineImpl f = new FinishingLineImpl();

        for (int i = 0; i<10 ; i++)
        {
            System.out.println("Creating a horse with id = " + (i+1));
            String strI = Integer.toString(i+1);
            HorseImpl h = new HorseImpl(strI,f);
            e.execute(h);
        }

        e.shutdown();
        e.awaitTermination(60000, TimeUnit.SECONDS); 

        f.print();
    }
}