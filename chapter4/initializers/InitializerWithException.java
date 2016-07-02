
class InitializerWithException {
 	static int[] x = new int[0];

 	static {
  		x[0] = 10;
  	}

 	public static void main(String[] args){
  		InitializerWithException ax = new InitializerWithException();
	}
 }   