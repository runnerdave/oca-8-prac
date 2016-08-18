import java.util.*;

public class Squirrel {
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
		System.out.println(s1);
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