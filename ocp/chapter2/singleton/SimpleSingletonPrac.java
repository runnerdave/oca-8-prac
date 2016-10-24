public class SimpleSingletonPrac {
	public static void main(String... args) {
		System.out.println("===Getting instance of simple singleton===");
		HayStorage hs = HayStorage.getInstance();
		System.out.println("Hay quantity:" + hs.getHayQuantity());
		hs.addHay(2);
		System.out.println("increase Hay quantity by two:" + hs.getHayQuantity());
		hs = HayStorage.getInstance();
		System.out.println("hay instance class:" + hs.getClass());
	}
} 
class HayStorage {
	private int quantity = 0;
	private HayStorage() {}
	private static final HayStorage instance = new HayStorage();
	public static HayStorage getInstance() {
		return instance;
	}
	public synchronized void addHay(int amount) {
		quantity += amount;
	}
	public synchronized boolean removeHay (int amount) {
		if(quantity < amount) return false;
		quantity -= amount;
		return true;
	}
	public synchronized int getHayQuantity() {
		return quantity;
	}
}