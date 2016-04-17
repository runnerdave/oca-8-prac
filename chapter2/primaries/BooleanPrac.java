public class BooleanPrac{
	public static void main(String... a) {
		/* 

		 Boolean.parseBoolean(String ) method returns a primitive boolean and not a Boolean object 
		 (Note - Same is with the case with other parseXXX methods such as Integer.parseInt - they return primitives 
		 and not objects). 
		 The boolean returned represents the value true if the string argument is not null and is equal, ignoring case, 
		 to the string "true".  
		 Boolean.valueOf(String ) and its overloaded Boolean.valueOf(boolean ) version, on the other hand, work similarly 
		 but return a reference to either Boolean.TRUE or Boolean.FALSE wrapper objects. 
		 Observe that they dont create a new Boolean object but just return the static constants TRUE or FALSE defined in 
		 Boolean class.
		*/

		 System.out.println("Boolean prac, Boolean.TRUE:" + Boolean.TRUE);
		 if(!Boolean.FALSE)
		 	System.out.println("Boolean.FALSE:" + Boolean.FALSE);

	}
}