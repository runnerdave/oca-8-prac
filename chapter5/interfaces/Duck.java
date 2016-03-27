public class Duck extends Animal implements Fly, Run {

     public void run() {
          System.out.println("i am running");
     }

     public static void sysoutRun() {
          System.out.println("i am running with sysout");
     }

     public void fly() {
          System.out.println("i am flying");
     }

     public Duck(){
          
          super(2);
          System.out.println("hello");
     }

     {
          System.out.println("before hello");
     }
     
     public static void main(String... args){
          /*
          Example where even though compiles a class cast exception is thrown
          Live duckie = new Animal();          
          ((Duck)duckie).fly();   
          */          

          Live duckie = new Duck(); 

          duckie.live();  
          ((Duck)duckie).run(); 
          //static methods
          Live.sysoutLive();  


          Duck duckie2 = new Duck(); 

          duckie2.live();  
          duckie2.run(); 
          //static methods
          duckie2.sysoutRun();  
          duckie2.showDefault();
          System.out.println(((Live)duckie2).heart + " heart");

          System.out.println("duckie three");
          Animal duckie3 = new Animal(3);  
          System.out.println("duckie 3 #legs:" + duckie3.numberOfLegs); 
          System.out.println(duckie3.numberOfLegs); 
          System.out.println("----------");
          duckie3 = new Duck();      
          ((Duck)duckie3).fly();   
          System.out.println("duckie 3 #nails:" + duckie3.nails); 
     }

}
