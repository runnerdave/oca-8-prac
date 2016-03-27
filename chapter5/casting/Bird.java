public class Bird extends Animal {

     public void doing(){
          System.out.println("I sing");
     }     

     public static void main(String... args){
          Bird birdy = new Bird();
          birdy.doing();

          Animal birdy2 = new Bird();
          birdy2.doing();
          System.out.println(birdy2 instanceof Animal);

          Animal birdy3 = new Animal();
          birdy3.doing();

          //Bird birdy4 = new Animal();   does not compile
          //birdy4.doing();

          System.out.println("--");
          ((Animal)birdy2).doing();
          System.out.println(birdy2 instanceof Animal);

          //Animal birdy5 = new Object(); does not compile
          //birdy5.doing();

          System.out.println(((Object)birdy3).toString());

          Action birdy6 = new Bird();
          birdy6.doing();
          Action.eating();
          ((Animal)birdy6).living();
          System.out.println(birdy6 instanceof Animal);

     }
}
