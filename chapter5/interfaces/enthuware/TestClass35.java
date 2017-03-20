/* Q. 35 of exam for OCP*/

interface House{
	public default String getAddress(){
		return "101 Main Str";
	}
}

interface Office {
	public static String getAddress(){
		return "101 Smart Str";
	} 
}  

interface WFH extends House, Office{ }  

class HomeOffice implements House, Office{
	public String getAddress(){
		return "R No 1, Home";
	} 
}  

public class TestClass35 {
	public static void main(String[] args) {
		Office off = new HomeOffice(); //1
		System.out.println(off.getAddress()); //2
		//WORKING VERSION System.out.println(Office.getAddress()); //2
	}
}

/*
answer: Line at //2 will cause compilation to fail.

Since the declared type of variable off is Office, compiler will check the call to 
getAddress against Office interface. However, getAddress in Office is static and 
Java 8 requires static interface method to be invoked using the interface name 
instead of a reference variable. That is why, the compiler will raise the following 
error message:  

TestClass.java:26: error: illegal static interface method call
     System.out.println(h.getAddress()); //2
                                     ^
     the receiver expression should be replaced with the type qualifier
    'Office'
     1 error
*/