public class ZooKeeper {
	public static void main(String... a) {
		FoodFactory.feedAnimal("zebra").consumed();
		FoodFactory.feedAnimal("goat").consumed();
		FoodFactory.feedAnimal("bear").consumed();
	}
}