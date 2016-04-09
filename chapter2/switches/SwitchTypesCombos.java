public class SwitchTypesCombos {
	
	//CASE 1 - type int -- case label char
	//Note that the following is invalid though because a char cannot be assigned to an Integer:
	/*
	Integer x = 1;  // int x = 1; is valid. 
	switch(x){
	    case 'a' : System.out.println("a");
	}
	*/

	//CASE 2 - type float -- case label int -- should fail

	//CASE 3 - type byte -- case label float -- should fail

	//CASE 4 - type char -- case label byte -- should fail
	/*This will not work in all cases because a byte may have negative values which cannot be assigned to a char. 
	For example, char ch = -1; does not compile. Therefore, the following does not compile either:  */
	/*
	char ch = 'x';
	switch(ch){
	           case -1 :        System.out.println("-1"); break; 
	 // This will not compile : "possible loss of precision"
	            default:        System.out.println("default");
	}
	*/

	// CASE 5 - type boolean -- case boolean -- should fail

	public static void main(String... s) {

		System.out.println("==CASE 0: int to int, int i=1 chooses 1");
		int i = 1;
		switch(i) {
			case 1:
				System.out.println("is 1");
				break;
			case 2:
				System.out.println("is 2");
				break;
		}


		System.out.println("==CASE 1: int to char, j = 49 chooses (int)'1'=" + (int)'1');
		int j = 49;
		switch(j) {
			case '1':
				System.out.println("is 1 or '49'");
				break;
			case '2':
				System.out.println("is 2");
				break;
			default:
				System.out.println("nothing!");
		}

		System.out.println("==CASE 2: float to int, k = 49f throws exception");
		float k = 49f;
		switch(k) {
			case 49f:
				System.out.println("is 49f or 49");
				break;
			case '2':
				System.out.println("is 2");
				break;
			default:
				System.out.println("nothing!");
		}
	}

}