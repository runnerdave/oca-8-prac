public class StuckTurkeyCage implements AutoCloseable {
	public void close() throws Exception {
		throw new Exception("Cage door does not close");
	}
	public static void main(String[] args) throws Exception {
		try (StuckTurkeyCage t = new StuckTurkeyCage()) { // ONLY COMPILES if main method throws exception
			System.out.println("put turkeys in");
		}
	}
}