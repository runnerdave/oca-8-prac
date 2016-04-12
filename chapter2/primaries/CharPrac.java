public class CharPrac {
	public static void main(String... a) {
		System.out.println("in char prac");
		char c = 'a';
		System.out.println("c:" + c + " as int:" + (int)c);
		//c = -97; DOES NOT COMPILE lossy convertion error
		c = 97;
		System.out.println("c:" + c + " as int:" + (int)c);

	}
}