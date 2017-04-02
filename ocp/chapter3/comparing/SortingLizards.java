import java.util.*;

//What is the result of the following code?
public class SortingLizards {   
	static class Lizard implements Comparator<Lizard> {      
		int weight;      
		Lizard(int w) { weight = w; }      
		public int compare(Lizard l, Lizard m) {         
			return l.weight-m.weight;      
		}      

		public String toString() { return "" + weight; }   
	}   

	public static void main(String[] args) {
	      List<Lizard> list = new ArrayList<>();      
	      list.add(new Lizard(5));      
	      list.add(new Lizard(4));      
	      list.add(new Lizard(7));      
	      Collections.sort(list);      //does not compile because it should implement comparable not comparator
	      //Collections.sort(list, new Lizard(0));   //with this line would compile   
	      System.out.println(list);  
	} 
}