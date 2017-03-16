import java.io.*;
import java.time.*;

public class StudentSerializer {
	public static void serializeStudent(Student student, File dataFile) {
		try(OutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
			((ObjectOutputStream)os).writeObject(student);
		} catch (FileNotFoundException e) {
			//file not found
		} catch (IOException e) {
			//io exception
		}

	}

	public static Student deserializeStudent(File dataFile) {
		Student student = null;
		try(InputStream is = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
			Object obj = ((ObjectInputStream)is).readObject();
			if (obj instanceof Student) {
				student = (Student)obj;
			}
		} catch (FileNotFoundException e) {
			//file not found
		} catch (IOException e) {
			//io exception
		} catch (ClassNotFoundException e) {
			//class not found
		}
		return student;
	}

	public static void main(String... args) {
		System.out.println("===Serializing students===");
		Student student = new Student("Juan", 33, LocalDate.now());
		Student student2 = new Student("Pedro", 34, LocalDate.now());
		System.out.println("Before serialization:");
		System.out.println(student);
		System.out.println(student2);
		File file = new File("student.dat");
		serializeStudent(student, file);
		File file2 = new File("student2.dat");
		serializeStudent(student2, file2);

		Student deserializedStudent = deserializeStudent(file);
		Student deserializedStudent2 = deserializeStudent(file2);
		System.out.println("After serialization:");
		System.out.println(deserializedStudent);
		System.out.println(deserializedStudent2);
	}
}