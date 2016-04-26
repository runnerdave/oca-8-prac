
public class ArrayIndexPrac{
 	public static int[ ] getNullArray() {  return null;  }
 	public static int[ ] getArray() {  return new int[] {1,2,3};  }
 	public static void main(String[] args){
		int index = 1;
		try{
			getNullArray()[index=2]++;
		}
		catch (Exception e){  }  //empty catch
		System.out.println("index = " + index);
		
		System.out.println("getArray = " + java.util.Arrays.toString(getArray()));
		System.out.println("value at index 1 = " + getArray()[1]);
		System.out.println("value at index 1 = " + getArray()[1]++);
		System.out.println("value at index 2 = " + ++getArray()[1]);

		System.out.println("value for index++ = " + index++);
		System.out.println("value for index = " + index);
	} 
}