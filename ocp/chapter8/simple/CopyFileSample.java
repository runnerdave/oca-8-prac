import java.io.*;
import java.text.DecimalFormat;

public class CopyFileSample {
	public static void copy(File source, File destination) throws IOException {
		try (InputStream in = new FileInputStream(source); 
			OutputStream out = new FileOutputStream(destination)) { 
			int b;
			while((b = in.read()) != -1) {
				out.write(b); 
			}
		} 
	}
	public static void copyModifiedFaster(File source, File destination) throws IOException {
		try (InputStream in = new BufferedInputStream(new FileInputStream(source)); 
			OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) { 
			int b;
			while((b = in.read()) != -1) {
				out.write(b); 
			}
		} 
	}
	public static void copyFasterProper(File source, File destination) throws IOException {
		try (
			InputStream in = new BufferedInputStream(new FileInputStream(source)); 
			OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
				byte[] buffer = new byte[1024];
				int lengthRead;
				while ((lengthRead = in.read(buffer)) > 0) {
					out.write(buffer,0,lengthRead);
					out.flush(); 
				}
		} 
	}
	public static void copyReaderWriter(File source, File destination) throws IOException {
		try (Reader in = new FileReader(source);
			 Writer out = new FileWriter(destination)) {
			int b;
			while((b = in.read()) != -1) {
				out.write(b); 
			}
		}
	}
	public static void copyReaderWriterFaster(File source, File destination) throws IOException {
		try (Reader in = new BufferedReader(new FileReader(source));
			 Writer out = new BufferedWriter(new FileWriter(destination))) {
			int b;
			while((b = in.read()) != -1) {
				out.write(b); 
			}
		}
	}
	public static void copyStreamToWriter(File source, File destination) throws IOException {
		try (Reader in = new InputStreamReader(new FileInputStream(source));
			 Writer out = new FileWriter(destination)) {
			int b;
			while((b = in.read()) != -1) {
				out.write(b); 
			}
		}
	}
	
	public static void main(String[] args) throws IOException { 
		DecimalFormat formatter = new DecimalFormat("#,###");

		File source = new File("data/Zoo.txt");
		File destination = new File("data/ZooCopy.txt"); 
		Long startTime;
		long endTime;

		startTime = System.nanoTime();
		copyFasterProper(source,destination);
		endTime = System.nanoTime();
		System.out.println("Time for copyFasterProper method:" + formatter.format(endTime-startTime));		

		startTime = System.nanoTime();
		copyModifiedFaster(source,destination);
		endTime = System.nanoTime();
		System.out.println("Time for copyModifiedFaster method:" + formatter.format(endTime-startTime));		

		startTime = System.nanoTime();
		copy(source,destination);
		endTime = System.nanoTime();
		System.out.println("Time for copy method:" + formatter.format(endTime-startTime));

		startTime = System.nanoTime();
		copyReaderWriter(source,destination);
		endTime = System.nanoTime();
		System.out.println("Time for copyReaderWriter method:" + formatter.format(endTime-startTime));

		startTime = System.nanoTime();
		copyReaderWriterFaster(source,destination);
		endTime = System.nanoTime();
		System.out.println("Time for copyReaderWriterFaster method:" + formatter.format(endTime-startTime));

		startTime = System.nanoTime();
		copyStreamToWriter(source,destination);
		endTime = System.nanoTime();
		System.out.println("Time for copyStreamToWriter method:" + formatter.format(endTime-startTime));
	} 
}
