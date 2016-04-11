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

		float k = 49.0f;
		System.out.println("==CASE 2: float to int, k = 49f does not compile:" + k);		
		// switch(k) {
		// 	case 49.0f:
		// 		System.out.println("is 49f or 49");
		// 		break;
		// 	default:
		// 		System.out.println("nothing!");
		// }

		byte l = 49;	
		System.out.println("==CASE 3: byte to float, l = 49 does not compile:" + l);
		switch(l) {
			// case 49.0f:
			// 	System.out.println("is 49f or 49");
			// 	break;
			default:
				System.out.println("case 3 - nothing!");
		}

		char ch = 'x';	
		final byte b = 120;	
		System.out.println("==CASE 4(the good one): char to byte \"120\", ch = 'x':" + ch + " to int:" + (int)ch);
		switch(ch){
	 			case b :
	 				System.out.println("120"); 
					break; 
	  			default:
	  				System.out.println("default");
		}
		System.out.println("==CASE 4(the bad one): char to byte \"-1\", ch = 'x':" + ch + " to int:" + (int)ch);		
		switch(ch){
				// case -1 :
				// 	System.out.println("-1"); 
				// 	break; 
					// This will not compile : "possible loss of precision"
				default:
					System.out.println("default");
		}
	}

}