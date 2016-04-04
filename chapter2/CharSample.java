public class CharSample {
	public static char myChar;

	public static void main(String[] args){
		//String test = true;  DOES NOT COMPILE
		//System.out.println(test);
		System.out.println("default value of char '\u0000':" + myChar + "|");
		for (char x = 'a'; x <= 'c'; x++) {
			System.out.println(x + " " + (int)x);
		}
		System.out.println("Should print -\u00A1- ¡:" + (char)161);
		System.out.println("Should print -\u00BF- ¿:" + (char)191);
		System.out.println("Should print -\u00F1- ñ:" + (char)241);

	}
}
