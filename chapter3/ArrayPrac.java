import java.util.*;
public class ArrayPrac {

	public static void main(String... s) {
		int[] intArray = {6,2,8};
		int[] intArray2 = {6,2,8};
		System.out.println(Arrays.toString(intArray));
		System.out.println("compare with == " + (intArray == intArray2));
		System.out.println("compare with .equals " + (intArray.equals(intArray2)));
		intArray = intArray2;
		System.out.println("compare with == " + (intArray == intArray2));
		System.out.println("compare with .equals " + (intArray.equals(intArray2)));
		System.out.println("Length: " + intArray.length);
		System.out.println(Arrays.binarySearch(intArray, 2));
		System.out.println(Arrays.binarySearch(intArray, 6));
		System.out.println(Arrays.binarySearch(intArray, 8));
		Arrays.sort(intArray);
		System.out.println(Arrays.toString(intArray));
		System.out.println(Arrays.binarySearch(intArray, 2));
		System.out.println(Arrays.binarySearch(intArray, 6));
		System.out.println(Arrays.binarySearch(intArray, 8));
		System.out.println(Arrays.binarySearch(intArray, 4));
		System.out.println(Arrays.binarySearch(intArray, 7));
int [] z = new int[0];
	}
}
