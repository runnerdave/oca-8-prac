import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;

public class MyException {
	void method () throws Exception {
		System.out.println("in method");
		try {
			System.out.println("in try...");
			//throw new RuntimeException("rt excption");
                	//int i = 1/0; 
			InputStream f = new FileInputStream("Initializer.java");
			f.skip(12l);
			throw new ThreadDeath();
		} catch (RuntimeException r) {
			System.out.println("in 1st catch...");
			r.printStackTrace();
			//int i = 1/0; 
			//throw new Exception("just excption");
		} catch (IOException e) {
			System.out.println("in ioexception catch...");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("in 2nd catch...");
			System.out.println(e.getMessage());
		} catch (Error e) {
			System.out.println("in error catch...");
			e.printStackTrace();
		} finally {
			System.out.println("in finally...");
		}
	}
	
	public static void main(String... args) throws Exception {
		MyException me = new MyException();
		me.method();
	}
}
