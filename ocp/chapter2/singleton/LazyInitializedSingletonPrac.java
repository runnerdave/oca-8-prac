public class LazyInitializedSingletonPrac {
	public static void main(String... args) {
		System.out.println("===Getting instance of lazy initialized singleton===");
		VisitorTicketTracker hs = VisitorTicketTracker.getInstance();
		System.out.println("VisitorTicketTracker instance class:" + hs.getClass());
	}
}

class VisitorTicketTracker {
	private static VisitorTicketTracker instance;
	private VisitorTicketTracker() {
	}
	public static synchronized VisitorTicketTracker getInstance() {
		if(instance == null) {
			instance = new VisitorTicketTracker(); 
		}
		return instance;
	}
}