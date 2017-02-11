import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
public class ConcurrentModificationPrac {
	public static void main(String... a) {
		Map<String, Object> foodData = new HashMap<String, Object>(); 
		// Map<String, Object> foodData = new ConcurrentHashMap<String, Object>(); //DOES NOT THROW EXCEPTION
		foodData.put("penguin", 1);
		foodData.put("flamingo", 2);
		System.out.println("before:" + foodData);
		for(String key: foodData.keySet())
			foodData.remove(key);
		System.out.println("after:" + foodData);
	}
}