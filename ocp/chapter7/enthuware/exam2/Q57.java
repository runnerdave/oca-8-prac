//q57

public class Q57 {

	public static void reader(String fileName1) throws Exception{
		try (FileReader fr = new FileReader(fileName1);) {  
			int charRead = 0;
			while ((charRead = fr.read()) != -1) {
			            System.out.println("Read char " + charRead);
			}
		}
	}
}

/*
What can be done to the above code to make it read Strings instead of chars?

a. Chain fr to a StringReader.
b. Use fr.readString instead of fr.read.
c. Chain fr to a BufferedReader.
d. Chain fr to a DataReader.

answer c

a is wrong because: 
While StringReader is a valid class but it creates a Reader out of a String. It does not read Strings from a Reader. For example: StringReader sr = new StringReader("some long string"); 

b is wrong because:
FileReader doesn't provide higher level methods for reading Strings.

c is right because:
A Reader can be chained to a BufferedReader to read Strings.

d is wrong because:
There is no such class as DataReader. There is a java.io.DataInputStream though,  
which lets an application read primitive Java data types from an underlying input 
stream in a machine-independent way. An application uses a java.io.DataOutputStream to
write data that can later be read by a java.io.DataInputStream.
*/