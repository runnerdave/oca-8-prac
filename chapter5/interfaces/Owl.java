interface Nocturnal {
     default boolean isBlind() { return false; }
}


public class Owl implements Nocturnal {

     public boolean isBlind() { return true; }

     public static void main(String[] args) {

          Nocturnal nocturnal = (Nocturnal)new Owl();

          System.out.println(((Nocturnal)nocturnal).isBlind());

     }
}
