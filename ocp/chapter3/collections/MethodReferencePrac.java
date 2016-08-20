import java.util.*;
public class MethodReferencePrac {
	public static void main(String... a) {
		Map<String,String> animals = new HashMap<>();
		animals.put("cat","boomer");
		animals.put("dog","pluto");
		animals.put("sheep","dolly");
		System.out.println("======forEach in the map:=======");
		animals.forEach((K,V) -> System.out.println(K + ":" + V));
		System.out.println("======forEach in the keySet:=======");
		animals.keySet().forEach(System.out::println);
		System.out.println("======forEach in the stream of the values collection:=======");
		animals.values().stream().forEach(System.out::println);
	}
}
