

import java.io.*;

public class q21 {

	/*
	Assuming the following class has proper public getter/setter methods for all of its private fields, 
	which of the following fields will always be null after an instance of the class 
	is serialized and then deserialized? (Choose all that apply.)
	A. name 
	B. tail 
	C. age 
	D. friends 
	E. birthPlace 
	F. The code does not compile. 
	G. The code compiles but throws an exception at runtime

	Answer: A;C 

	The code compiles and runs without issue, so F and G are incorrect. 
	Note that serialUID is not the same as serialVersionUID, although since serialVersionUID 
	is recommended but not required, this does not pose any compilation issues. 
	Just be aware that serialUID will not be used by the serialization process for version control. 
	The name variable and age variable are both transient, which means that their values will not be 
	saved upon serialization. Upon deserialization, the default initializations and constructor will 
	be skipped, and they will both be null; therefore A and C are correct. 
	B is incorrect because tail is not transient and could be set by a caller before being serialized. 
	D is also incorrect because a serialized empty array is not the same as a null pointer. 
	Even though these non-transient fields could be set to null, they are not guaranteed 
	to be null after deserialization. E is incorrect because the static value will not be serialized; 
	it will be available on the class after deserialization.

	*/
	public static void main(String... args) throws FileNotFoundException {
		System.out.println("Reading from Zebra:");
	}
}

class Zebra implements Serializable { 
	private static final long serialUID = 1L; 
	private transient String name = "George"; 
	private static String birthPlace = "Africa"; 
	private transient Integer age;
	private java.util.List<Zebra> friends = new java.util.ArrayList<>(); 
	private Object tail = null;
	{ age = 10;}
	public Zebra() { 
		this.name = "Sophia";
	} 
}