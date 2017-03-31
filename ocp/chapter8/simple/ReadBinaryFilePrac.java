import java.io.*;

public class ReadBinaryFilePrac {
	public static void main(String... args) {
		if (args.length != 2) {
			System.out.println("Usage: java ReadBinaryFilePrac FILENAME COLS");
			System.exit(-1);
		}
		
		try(FileInputStream in = new FileInputStream(args[0])){
			printHexStream(in, Integer.parseInt(args[1]));
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

	public static void printHexStream(final InputStream inputStream, final int numberOfColumns) throws IOException{
	    long streamPtr=0;
	    while (inputStream.available() > 0) { 
	        final long col = streamPtr++ % numberOfColumns;
	        System.out.printf("%02x ",inputStream.read());
	        if (col == (numberOfColumns-1)) {
	            System.out.printf("\n");
	        }
	    }
	}
}