import java.util.*;

public class Squirrel {
	MultiFieldComparator multi = new MultiFieldComparator();
	ChainingComparator chain = new ChainingComparator();

	private int weight;
	private String species;
	public Squirrel(String theSpecies) {
		if (theSpecies == null) throw new IllegalArgumentException();
		species = theSpecies;
	}
	public int getWeight() { return weight; }
	public void setWeight(int weight) { this.weight = weight; }
	public String getSpecies() { return species; }

	public static void main(String... a) {
		Squirrel s1 = new Squirrel("gray");
		s1.setWeight(234);
		Squirrel s2 = new Squirrel("brown");
		s2.setWeight(134);
		Squirrel s3 = new Squirrel("brown");
		s2.setWeight(100);

		Set<Squirrel> squirrelSet = new TreeSet<>();
		try {
			squirrelSet.add(s1);//Treeset expects a Comparable object
		} catch(ClassCastException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("comparing s1 to s2 multi:" + s1.multi.compare(s1,s2));
	}
}

class MultiFieldComparator implements Comparator<Squirrel> {
	public int compare(Squirrel s1, Squirrel s2) {
		int result = s1.getSpecies().compareTo(s2.getSpecies());
		if (result != 0) return result;
		return s1.getWeight()-s2.getWeight();
	}
}

class ChainingComparator implements Comparator<Squirrel> {
	public int compare(Squirrel s1, Squirrel s2) {
		Comparator<Squirrel> c = Comparator.comparing(s -> s.getSpecies());
		c = c.thenComparingInt(s -> s.getWeight());
		return c.compare(s1, s2);
	}
}