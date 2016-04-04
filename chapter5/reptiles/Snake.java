public class Snake extends Reptile { 
	protected int length = 6;
	protected int girth = 12 + super.girth;
	protected boolean hasLegs() {
		return false; 
	}
	protected double getWeight() throws InsufficientDataException{ 
		return 4;
	} 

	public static void main(String... h) {
		Reptile r = new Snake();
		Snake s = new Snake();
		Reptile pureReptile = new Reptile();

		try {
			System.out.println("reference as Reptile class Snake length:" + r.length);
			System.out.println("reference as Reptile class Snake girth:" + r.girth);
			System.out.println("reference as Reptile class Snake (cast as Snake) girth:" + ((Snake)r).girth);
			System.out.println("reference as Reptile class Snake (cast as Reptile) length:" + ((Reptile)r).length);
			System.out.println("reference as Reptile class Snake (cast as Snake) length:" + ((Snake)r).length);
			System.out.println("reference as Reptile class Snake getWeight:" + ((Reptile)r).getWeight());
			System.out.println("reference as Snake class Snake getWeight:" + s.getWeight());
			System.out.println("reference as Reptile class Snake hasLegs:" + s.hasLegs());
			System.out.println("reference as Reptile class Reptile hasLegs:" + pureReptile.hasLegs());
		}
		catch(Exception id) {
			System.out.println("exception caught");
			System.out.println(id.getMessage());
		}



	}
}
