public class Beaver extends Rodent implements Swim {
     public static Integer chew() throws RuntimeException {
          System.out.println("Beaver is chewing on wood");
          return 2;
     }

     public static void main(String... s) {
     	System.out.println(Beaver.chew());
     }

     public void say() {};
}
