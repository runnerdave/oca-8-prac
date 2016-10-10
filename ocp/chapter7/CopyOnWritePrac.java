import java.util.*;
import java.util.concurrent.*;
public class CopyOnWritePrac {
	public static void main(String... a) {
		List<Integer> listCopyOnWrite = new CopyOnWriteArrayList<>(Arrays.asList(4,3,52)); 
		for(Integer item: listCopyOnWrite) {
			System.out.print(item+" ");
			listCopyOnWrite.add(9); 
		}
		System.out.println(); 
		System.out.println("Size: "+listCopyOnWrite.size());

		List<Integer> list = new ArrayList<>(Arrays.asList(4,3,52)); 
		for(Integer item: list) {
			System.out.print(item+" ");
			list.add(9); 
		}
		System.out.println(); 
		System.out.println("Size: "+list.size());
	}
}