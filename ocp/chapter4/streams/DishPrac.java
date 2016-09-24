import java.util.*;
import java.util.function.*;
import java.util.stream.*;
public class DishPrac {	

	public static void main(String... args) {
		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT), 
									new Dish("beef", false, 700, Dish.Type.MEAT), 
									new Dish("chicken", false, 400, Dish.Type.MEAT),
									new Dish("french fries", true, 530, Dish.Type.OTHER), 
									new Dish("rice", true, 350, Dish.Type.OTHER),
									new Dish("season fruit", true, 120, Dish.Type.OTHER), 
									new Dish("pizza", true, 550, Dish.Type.OTHER),
									new Dish("prawns", false, 300, Dish.Type.FISH), 
									new Dish("salmon", false, 450, Dish.Type.FISH)
								 );
		System.out.println(menu);
		//quiz 5.1 from java 8 in action:
		//How would you use streams to filter the first two meat dishes?
		System.out.println("2 meat dishes");
		System.out.println(menu.stream().filter(s->s.getType()==Dish.Type.MEAT).limit(2).collect(Collectors.toList()));
		System.out.println("2 vegetarian");
		System.out.println(menu.stream().filter(Dish::isVegetarian).limit(2).collect(Collectors.toList()));

	}
}
class Dish {
	private final String name; private final boolean vegetarian; private final int calories;
	private final Type type;
	public Dish(String name, boolean vegetarian, int calories, Type type) { this.name = name;
	this.vegetarian = vegetarian;
	this.calories = calories;
	this.type = type; }
	public String getName() { return name;
	}
	public boolean isVegetarian() { return vegetarian;
	}
	public int getCalories() { return calories;
	}
	public Type getType() { return type;
	} @Override
	public String toString() { return name;
	}
	public enum Type { MEAT, FISH, OTHER } 
}