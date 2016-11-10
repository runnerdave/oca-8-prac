import java.util.*;
import java.io.*;

public class q22 {

	/*
	What is the value of name after an instance of Eagle is serialized and then deserialized?

	A. Bridget 
	B. Matt
	C. Janette
	D. Daniel
	E. null
	F. The code does not compile.
	G. The code compiles but throws an exception at runtime.
	H. The value may not be known until runtime.

	Answer: E First off, even though the Bird class implements Serializable, 
	it does not define a static serialVersionUID variable, which is recommended but not required; 
	therefore it compiles without issue and F is incorrect. The code also runs without issue, 
	so G is incorrect. The key here is that Java will call the constructor for the first 
	non-serializable no-argument parent class during deserialization, skipping any constructors 
	and default initializations for serializable classes in between, including Eagle and Bird itself. 
	Therefore, Object() is the first constructor called. All default initializations are skipped, 
	so A, B, C, and D are all incorrect. Since the name is marked transient, 
	the deserialized value is null and E is correct. H is also incorrect, 
	because the caller cannot change the serialized value of name with setName(), 
	since name is marked transient.	 

	*/
	public static void main(String... args) throws FileNotFoundException, IOException,
													ClassNotFoundException {
		List<Bird> birds = new ArrayList<>();
		Bird bird1 = new Bird();
		bird1.setName("Pedro");
		Bird bird2 = new Bird();
		bird2.setName("Juan");
		birds.add(bird1);
		birds.add(bird2);
		System.out.println("List of Birds before serialization:" + birds);
		//serialize to file
		File dataFile = new File("birds.data"); 
		SerializerUtils.createBirdsFile(birds, dataFile);
		System.out.println("Reading from birds:");
		System.out.println(SerializerUtils.getBirds(dataFile));
	}
}

class Bird implements Serializable {
	protected transient String name = "Bridget";
	public void setName(String name) { 
		this.name = name; 
	} 
	public String getName() { 
		return name; 
	}
	public Bird() {
		this.name = "Matt"; 
	}
	@Override
	public String toString() {
		return "my name is:" + this.name;
	}
}

class Eagle extends Bird implements Serializable { 
	{ this.name = "Janette"; }
	public Eagle() {
		this.name = "Daniel"; 
	}
}
