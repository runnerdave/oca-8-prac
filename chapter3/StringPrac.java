import java.util.*;
public class StringPrac{
	public static void main(String[] args){
		String myString = "unoSeLaCala";
		String myString2 = "\t\n y dos  ";
		String myString3 = myString2.trim().concat(myString);
		System.out.println(myString);
		System.out.println("largo de myString" + myString.length());
		char c = myString.charAt(3);
		System.out.println("el caracter 3 en unoSeLaCala es:" + c);
		System.out.println(myString2 + "|");
		System.out.println(myString3 + "|");
		System.out.println(myString2.trim() + "|");
		myString2 = myString2.trim();
		System.out.println(myString2 + "|");
		int i = 1;
		System.out.println(myString.substring(0,1));
		System.out.println(myString.substring(1,1));
		System.out.println(myString.substring(3,4));
		//String[] grades; grades = {"1","2"};//does not compile
		String[] grades = new String[] {"1","2"};
		System.out.println(Arrays.asList(grades));
	}
}
