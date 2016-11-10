
import java.util.*;
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
	public static void main(String... args) throws FileNotFoundException, IOException,
													ClassNotFoundException {
		ArrayList<Zebra> myZebras = new ArrayList<>();
		Zebra zebra1 = new Zebra();
		zebra1.setName("zebra1");
		zebra1.setAge(13);
		zebra1.setBirthPlace("Holland");
		zebra1.setTail(new Tail());
		Zebra zebra2 = new Zebra();
		zebra2.setName("zebra2");
		zebra2.setAge(14);
		zebra2.setBirthPlace("Caracas");
		zebra2.setTail(new Tail());
		myZebras.add(zebra1);
		myZebras.add(zebra2);
		System.out.println("List of Zebras before serialization:" + myZebras);
		//serialize to file
		File dataFile = new File("zebras.data"); 
		SerializerUtils.createZebrasFile(myZebras, dataFile);
		System.out.println("Reading from myZebras:");
		System.out.println(SerializerUtils.getZebras(dataFile));
	}
}

class Zebra implements Serializable { 
	private static final long serialUID = 1L; 
	private transient String name = "George"; 
	private static String birthPlace = "Africa"; 
	private transient Integer age;
	private java.util.List<Zebra> friends = new java.util.ArrayList<>(); 
	private Tail tail = null;
	{ age = 10;}
	public Zebra() { 
		this.name = "Sophia";
	}

	//added by me:
	public String getName() {
		return this.name;
	}
	public static String getBirthPlace() {
		return Zebra.birthPlace;
	}
	public Integer getAge() {
		return this.age;
	}
	public Tail getTail() {
		return this.tail;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static void setBirthPlace(String birthPlace) {
		Zebra.birthPlace = birthPlace;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setTail(Tail tail) {
		this.tail = tail;
	}
	@Override
	public String toString() {
		return "name:" + name 
				+ " - birthPlace:" + birthPlace 
				+ " - age:" + age 
				+ " - tail:" + tail;
				
	}
}

class Tail implements Serializable {}