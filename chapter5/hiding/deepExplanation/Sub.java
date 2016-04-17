class Base{
	int i=10; 

	public static void printName(){
		System.out.println("Base");
	}
 } 

public class Sub extends Base{
 	int i=20; //This i hides Base's i.  

 	public static void printName(){
		System.out.println("Sub");
	} 

 	public static void main(String... args){
		Sub s = new Sub(); 
		int k = s.i; //assigns 20 to k.  
		System.out.println("k should be 20:" + k);
		System.out.println("printName should be Sub:");
		s.printName();

		k = ((Base)s).i;//assigns 10 to k. 		
		System.out.println("k should be 10:" + k);
		System.out.println("printName should be Base:");
		((Base)s).printName();

		Base b = new Sub(); k = b.i;
		//assigns 10 to k because which field is accessed depends on the class of the variable 
		//and not on the class of the actual object. 
		System.out.println("k should be 10:" + k);
		System.out.println("printName should be Base:");
		b.printName();

		/*
		Same rule applies to static methods but the opposite is true for instance methods.*/
 	}

} 