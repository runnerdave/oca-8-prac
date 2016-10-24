public class DoubleCheckedSingletonPrac {
	public static void main(String... args) {
		System.out.println("===Getting instance of double checked lazy initialized singleton===");
		VisitorTicketTracker hs = VisitorTicketTracker.getInstance();
		System.out.println("VisitorTicketTracker instance class:" + hs.getClass());
	}
}

class VisitorTicketTracker {
	//volitalie prevents a subtle case where the compiler tries to optimize the code such that 
	//that the object is accessed before it is finished being constructed.
	private static volatile VisitorTicketTracker instance;
	private VisitorTicketTracker() {
	}
	public static synchronized VisitorTicketTracker getInstance() {
		if(instance == null) {
			synchronized(VisitorTicketTracker.class) {
				if(instance == null) {
					instance = new VisitorTicketTracker();
				}
			}
		}
		return instance;
	}
}