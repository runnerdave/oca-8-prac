public class Reptile {
	protected int length = 4;
	protected int girth = 8;
	protected boolean hasLegs() throws InsufficientDataException {
		throw new InsufficientDataException(); 
	}
	protected double getWeight() throws Exception { 
		return 2;
	} 
}