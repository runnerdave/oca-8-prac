import java.util.*;
public class ConcurrentModificationPrac {
	public static void main(String... a) {
		Map<String, Object> foodData = new HashMap<String, Object>(); 
		// Map<String, Object> foodData = new ConcurrentHashMap<String, Object>(); //DOES NOT THROW EXCEPTION
		foodData.put("penguin", 1);
		foodData.put("flamingo", 2);
		for(String key: foodData.keySet())
			foodData.remove(key);
	}
}