public class Animal extends Being implements Live {

     public static int numberOfLegs;

     public void live() {
          System.out.println("I am living");
     }

     public Animal(int legs){
          this.numberOfLegs = legs;     
     }
}
