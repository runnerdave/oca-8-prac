import java.util.concurrent.*;
import java.util.*;


/**
* -Running race of 400 meters.
* -Five thread groups, each with a country name
* -Two runners per group, ten in total
* -Each runner runs 200 meters
* -Print the winner and all the groups should complete the race
* -Print the time taken by each group to complete the race and highlight the winners time.
*/
public class RelayRaceAssignment {

	public static void main(String... args) throws InterruptedException, BrokenBarrierException {
		Map<String, List<Runner>> allTeams = new HashMap<>();

		CountDownLatch batonGER = new CountDownLatch(0);
    	CountDownLatch batonUSA = new CountDownLatch(0);
    	CountDownLatch batonJAM = new CountDownLatch(0);
    	CountDownLatch batonTT = new CountDownLatch(0);
    	CountDownLatch batonNAM = new CountDownLatch(0);

    	ThreadGroup ger = new ThreadGroup("Deutschland");
    	Runner gerRunner1 = new FirstRunner(batonGER, "Lars - GER");
    	Runner gerRunner2 = new SecondRunner(batonGER, "Bodo - GER");
		Thread lars = new Thread(ger, gerRunner1);
		Thread bodo = new Thread(ger, gerRunner2);		
		List<Runner> gerRunners = new ArrayList<Runner>(Arrays.asList(gerRunner1, gerRunner2));

		ThreadGroup usa = new ThreadGroup("USA");
    	Runner usaRunner1 = new FirstRunner(batonUSA, "Carl - USA");
    	Runner usaRunner2 = new SecondRunner(batonUSA, "Michael - USA");
		Thread lewis = new Thread(usa, usaRunner1);
		Thread johnson = new Thread(usa, usaRunner2);
		List<Runner> usaRunners = new ArrayList<Runner>(Arrays.asList(usaRunner1, usaRunner2));

		ThreadGroup jam = new ThreadGroup("Jamaica");
    	Runner jamRunner1 = new FirstRunner(batonJAM, "Usain - JAM");
    	Runner jamRunner2 = new SecondRunner(batonJAM, "Asafa - JAM");
		Thread bolt = new Thread(jam, jamRunner1);
		Thread powell = new Thread(jam, jamRunner2);
		List<Runner> jamRunners = new ArrayList<Runner>(Arrays.asList(jamRunner1, jamRunner2));

		ThreadGroup tt = new ThreadGroup("TrinidadAndTobago");
    	Runner ttRunner1 = new FirstRunner(batonTT, "Ato - TT");
    	Runner ttRunner2 = new SecondRunner(batonTT, "Richard - TT");
		Thread boldon = new Thread(tt, ttRunner1);
		Thread thompson = new Thread(tt, ttRunner2);
		List<Runner> ttRunners = new ArrayList<Runner>(Arrays.asList(ttRunner1, ttRunner2));

		ThreadGroup nam = new ThreadGroup("Namibia");
    	Runner namRunner1 = new FirstRunner(batonNAM, "Frankie - NAM");
    	Runner namRunner2 = new SecondRunner(batonNAM, "Daniel - NAM");
		Thread fredericks = new Thread(nam, namRunner1);
		Thread haitembu = new Thread(nam, namRunner2);
		List<Runner> namRunners = new ArrayList<Runner>(Arrays.asList(namRunner1, namRunner2));

		allTeams = new HashMap<>();
		allTeams.put(ger.getName(), gerRunners);
		allTeams.put(usa.getName(), usaRunners);
		allTeams.put(jam.getName(), jamRunners);
		allTeams.put(tt.getName(), ttRunners);
		allTeams.put(nam.getName(), namRunners);


		lars.start();
		lewis.start();
		bolt.start();
		boldon.start();
		fredericks.start();

		bodo.start();
		johnson.start();
		powell.start();
		thompson.start();
		haitembu.start();



		try {
			Thread.sleep(1000);
		} catch(InterruptedException ie) {
			//suppress this exception
		}

		

		Map<String, List<Runner>> result = new LinkedHashMap<>();

        allTeams.entrySet().stream()
                .sorted(Map.Entry.<String, List<Runner>>comparingByValue(byTotalTime))
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));

        
        System.out.println("====total times====");
		result.forEach((k,v)->{
			System.out.println(k + ":");			
			System.out.println(printTeamTimeDetails(v));
		});
	}

	static Comparator<List<Runner>> byTotalTime = (l1, l2) -> {
		if ((getTotalTeamTime(l1)) > (getTotalTeamTime(l2))) {
			return 1;
		} else {
			return -1;
		}
	};
	
	static long getTotalTeamTime(List<Runner> list) {
		return list.stream().map(r->r.getTotalTime()).reduce((a,b)->a+b).get();
	}

	static String printTeamTimeDetails(List<Runner> list) {
		StringBuilder sb = new StringBuilder();
		sb.append(getTotalTeamTime(list));
		sb.append("(").append(list).append(")");
		return sb.toString();
	}
}

abstract class Runner implements Runnable {

	protected final CountDownLatch baton;
	private final String name;
	protected long totalTime;

	@Override
	public String toString() {
		return this.name + ":" + totalTime;
	}

	long getTotalTime() {
		return totalTime;
	}

	Runner(CountDownLatch baton, String name) {
		this.baton = baton;
		this.name = name;
	}

	public void race(){
		long startTime = System.nanoTime();
		System.out.println(name + " started at: " + startTime);
		for(int distance=1; distance<=200; distance++){

			if (distance%50 == 0) {
				// System.out.println("Distance covered by " 
				// + name + " is: " + distance + " meters");
			}
		}
		long endTime = System.nanoTime();
		System.out.println(name + " finished at: " + endTime);
		this.totalTime = (endTime - startTime);
		System.out.println("Time taken by " + name + " is: " + totalTime);
	}

	@Override
	public abstract void run();
}

class FirstRunner extends Runner {

	public FirstRunner(CountDownLatch baton, String name) {
		super(baton, name);
	}

	public void run() {		
		this.race();
		baton.countDown();
	}
}

class SecondRunner extends Runner {
	public SecondRunner(CountDownLatch baton, String name) {
		super(baton, name);
	}

	public void run() {
		try {
            baton.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.race();
	}
	
}