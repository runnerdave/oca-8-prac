public class LambdaScope{

	private static String salutation = "hola";

	interface GreetingService {
		void sayMessage(String message);
	}

	public static void main(String[] a){
		GreetingService gs = message -> 
			System.out.println(message);
		gs.sayMessage(salutation);
	}
}
