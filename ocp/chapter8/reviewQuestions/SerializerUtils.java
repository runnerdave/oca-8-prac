import java.io.*;
import java.util.*;
public class SerializerUtils {
	public static List<Zebra> getZebras(File dataFile) throws IOException, ClassNotFoundException {
		List<Zebra> animals = new ArrayList<Zebra>(); 
		try (ObjectInputStream in = new ObjectInputStream(
			new BufferedInputStream(new FileInputStream(dataFile)))) { 
				while(true) {
					Object object = in.readObject(); 
					if(object instanceof Zebra)
						animals.add((Zebra)object); 
				}
		} catch (EOFException e) { 
			// File end reached
		}
		return animals; 
	}
	public static void createZebrasFile(List<Zebra> zebras, File dataFile) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(
			new BufferedOutputStream(new FileOutputStream(dataFile)))) {
				for(Zebra animal: zebras) 
					out.writeObject(animal);
		} 
	}
	public static List<Bird> getBirds(File dataFile) throws IOException, ClassNotFoundException {
		List<Bird> animals = new ArrayList<>(); 
		try (ObjectInputStream in = new ObjectInputStream(
			new BufferedInputStream(new FileInputStream(dataFile)))) { 
				while(true) {
					Object object = in.readObject(); 
					if(object instanceof Bird)
						animals.add((Bird)object); 
				}
		} catch (EOFException e) { 
			// File end reached
		}
		return animals; 
	}
	public static void createBirdsFile(List<Bird> animals, File dataFile) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(
			new BufferedOutputStream(new FileOutputStream(dataFile)))) {
				for(Bird animal: animals) 
					out.writeObject(animal);
		} 
	}
}