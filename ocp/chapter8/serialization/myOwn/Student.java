import java.io.*;
import java.time.*;

public class Student implements Serializable {
	private final long serialVersionUID = 1L;

	private String name;
	private static int age;
	private transient LocalDate today;
	private double markAverage;
	private static boolean male;
	private transient char international;
	private static boolean tall;

	{
		markAverage=5.0;
		international='L';
		male=true;
		tall=true;
	}

	public Student(String name, int age, LocalDate today) {
		this.name = name;
		this.age = age;
		this.today = today;
	}

	@Override
	public String toString() {
		return "name:" + name + "|age:" + age + "|today:" + today 
				+ "|markAverage:" + markAverage + "|male:" 
				+ male + "|international:" + international + "|tall:" + tall;
	}

}