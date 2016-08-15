import java.util.*;
public class AnimalTester {
	public static void main(String... a) {
		Animal myLion = new AnimalBuilder().setAge(3).setSpecies("Feline").setFavoriteFoods(Arrays.asList("meat","jam")).build();
		System.out.println("Age:" + myLion.getAge());
		System.out.println("Species:" + myLion.getSpecies());
		System.out.println("Favorite foods count:" + myLion.getFavoriteFoodsCount());
	}
}