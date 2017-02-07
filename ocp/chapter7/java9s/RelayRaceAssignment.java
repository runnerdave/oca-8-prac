import java.util.concurrent.*;


/**
* -Running race of 400 meters.
* -Five thread groups, each with a country name
* -Two runners per group, ten in total
* -Each runner runs 200 meters
* -Print the winner and all the groups should complete the race
* -Pront the time taken by each group to complete the race and highlight the winners time.
*/
public class RelayRaceAssignment {

	final static CyclicBarrier gun = new CyclicBarrier(11);

	static Runner runner = new Runner(gun);
	static ThreadGroup ger = new ThreadGroup("Deutschland");
	static Thread lars = new Thread(ger, runner, "Lars");
	static Thread bodo = new Thread(ger, runner, "Bodo");

	static ThreadGroup usa = new ThreadGroup("USA");
	static Thread lewis = new Thread(usa, runner, "Carl");
	static Thread johnson = new Thread(usa, runner, "Michael");

	static ThreadGroup jam = new ThreadGroup("Jamaica");
	static Thread bolt = new Thread(jam, runner, "Usain");
	static Thread powell = new Thread(jam, runner, "Asafa");

	static ThreadGroup tt = new ThreadGroup("TrinidadAndTobago");
	static Thread boldon = new Thread(tt, runner, "Ato");
	static Thread thompson = new Thread(tt, runner, "Richard");

	static ThreadGroup nam = new ThreadGroup("Namibia");
	static Thread fredericks = new Thread(nam, runner, "Frankie");
	static Thread haitembu = new Thread(nam, runner, "Daniel");

	public static void main(String... args) throws InterruptedException, BrokenBarrierException {
		lars.start();
		lars.join();
		bodo.start();

		lewis.start();
		lewis.join();
		johnson.start();

		bolt.start();
		bolt.join();
		powell.start();

		boldon.start();
		boldon.join();
		thompson.start();

		fredericks.start();
		fredericks.join();
		haitembu.start();

		bodo.join();


		// gun.await();
		// System.out.println("BANG!!");

	}

	

	
}

class Runner implements Runnable {

	private final CyclicBarrier gun;

	Runner(CyclicBarrier gun) {
		this.gun = gun;
	}

	public void race(){
	
		for(int distance=1; distance<=200; distance++){
			System.out.println("Distance covered by " + Thread.currentThread().getName() + " is: " + distance + " meters");
			
			//Check if race is complete if someone has already won
			boolean isRaceWon = this.isRaceWon(distance);
			if(isRaceWon){
				break;
			}
		}
	}

	private boolean isRaceWon(int totalDistanceCovered){
		boolean isRaceWon = false;
		if((Racer.winner == null ) && (totalDistanceCovered == 100)){
			String winnerName = Thread.currentThread().getName();
			Racer.winner = winnerName; //setting the winner name
			System.out.println("Winner is :"+Racer.winner);
			isRaceWon = true;
		} else if(Racer.winner == null) {
			isRaceWon = false;
		}else if(Racer.winner != null){
			isRaceWon = true;
		}
		return isRaceWon;
	}

	@Override
	public void run() {
		// try {
			//gun.await();
			this.race();
		// } catch (InterruptedException | BrokenBarrierException e) {
			
		// }		
	}
}