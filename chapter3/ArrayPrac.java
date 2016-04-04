import java.util.*;
public class ArrayPrac {

	public static void main(String... s) {
		int[] intArray = {6,2,8};
		int[] intArray2 = {6,2,8};
		System.out.println("The array contents:" + Arrays.toString(intArray));
		System.out.println("compare with == " + (intArray == intArray2));
		System.out.println("compare with .equals " + (intArray.equals(intArray2)));
		intArray = intArray2;
		System.out.println("compare with == (after references point to the same object)" + (intArray == intArray2));
		System.out.println("compare with .equals " + (intArray.equals(intArray2)));
		System.out.println("Length: " + intArray.length);
		System.out.println("BinarySearch in array for value \"2\":" + Arrays.binarySearch(intArray, 2));
		System.out.println("BinarySearch in array for value \"6\":" + Arrays.binarySearch(intArray, 6));
		System.out.println("BinarySearch in array for value \"8\":" + Arrays.binarySearch(intArray, 8));
		Arrays.sort(intArray);
		System.out.println("Array sorted:" + Arrays.toString(intArray));
		System.out.println("BinarySearch in array for value \"2\":" + Arrays.binarySearch(intArray, 2));
		System.out.println("BinarySearch in array for value \"6\":" + Arrays.binarySearch(intArray, 6));
		System.out.println("BinarySearch in array for value \"8\":" + Arrays.binarySearch(intArray, 8));
		System.out.println("BinarySearch in array for value \"4\":" + Arrays.binarySearch(intArray, 4));
		System.out.println("BinarySearch in array for value \"7\":" + Arrays.binarySearch(intArray, 7));
		int [] z = new int[0];
		System.out.println("print array of {6,2,8} with varargs:" + printWithVarargs(intArray));
		System.out.println("print array of {1,2,3} with varargs:" + printWithVarargs(1,2,3));
		System.out.println("print array of {1,2,3} with varargs:" + printWithVarargs(new int[] {1, 2, 3}));
		System.out.println("print array of {6,2,8} with array:" + printWithArray(intArray));
		//System.out.println("print array of {1,2,3} with array:" + printWithArray(1,2,3));  DOES NOT COMPILE
		System.out.println("print array of {1,2,3} with array:" + printWithArray(new int[] {1, 2, 3}));
		//System.out.println("print array of {1,2,3} with array:" + printWithArray({1, 2, 3}));
	}

	static String printWithVarargs(int... arg) {
		return Arrays.toString(arg);
	}

	static String printWithArray(int[] arg) {
		return Arrays.toString(arg);
	}
}
