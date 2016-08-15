public class FoodFactory {
	public static Food feedAnimal(String animal) {
		switch(animal) {
			case "zebra":
				return new Hay(23);
			case "bear":
				return new Fish(2);
			case "goat":
				return new Pellets(56);
		}
		throw new IllegalArgumentException("wrong food type");
	} 
}