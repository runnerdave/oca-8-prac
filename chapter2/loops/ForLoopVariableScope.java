public class ForLoopVariableScope {

	private static int j;
	
	public static void main(String... g) {
		while (j <= 5) {
               for (int j = 1; j <= 5; j++) {
               		System.out.print(j);
               }
               System.out.print("|");
               {
               		int j = 5;
	                while (j >= 0) {
	               		System.out.print(j);
	               		j--;
	                }
           		}
               j++;
               System.out.println();
        }

	}
}