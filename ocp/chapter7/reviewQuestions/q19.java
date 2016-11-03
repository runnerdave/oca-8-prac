import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.*;

public class q19 {

	/*
	What statements about the following code are true? (Choose all that apply.)
	A. It compiles without issue.
	B. The code will not compile because of line k2.
	C. The code will not compile because of line k3.
	D. The lock locks acquired on k1 and k4 are on the same object.
	E. The class correctly prevents concurrency issues for the value of tickets 
		when accessed by multiple threads.
	F. At most one instance of TicketManager will be created in the application.

	Answer:
	The class compiles without issue so A is correct, and B and C are incorrect. 
	The synchronized object on line k1 is TicketManager.class, while the synchronized object on line
	k4 is the instance of TicketManager. The class is not thread-safe because the makeTicketsAvailable()
	 method is not synchronized, and E is incorrect. One thread could call sellTickets() while another 
	 thread has unblocked accessed to makeTicketsAvailable(), causing an invalid number of tickets to be 
	 reached as part of a race condition. Finally, F is correct because the class synchronizes using a 
	 static getInstance() method, preventing more than one instance from being created.
	*/
}
class TicketManager {
	private TicketManager() { super(); }
	private static TicketManager instance;
	public static synchronized TicketManager getInstance() { // k1
		if (instance == null) instance = new TicketManager(); // k2
		return instance; 
	}
	private int tickets;
	public int getTicketCount() { return tickets; }
	public void makeTicketsAvailable(int value) { tickets += value; } // k3 
	public void sellTickets(int value) {
		synchronized (this) { // k4 tickets -= value;
		} 
	}
}