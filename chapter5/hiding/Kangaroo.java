public class Kangaroo extends Marsupial {
     public static boolean isBiped() {
          //ears++; not allowed
          return true;
     }

     public static int tails = 1;
     public int ears = 2;
     public void getKangarooDescription() {
          System.out.println("Kangaroo hops on two legs: "+isBiped());
          System.out.println("Kangaroo has "+tails+" tail(s)");
     }
     public static void main(String[] args) {
          Kangaroo joey = new Kangaroo();
          joey.getMarsupialDescription();
          joey.getKangarooDescription();
     }
}
