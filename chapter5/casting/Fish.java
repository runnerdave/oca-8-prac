public class Fish extends Animal implements Reaction {
     public void unDoing() {
          System.out.println("not doing it");
     }

     public static void main(String... args) {
          Animal fishy = new Fish();
          ((Fish)fishy).unDoing();
          new Fish().unDoing();

          System.out.println("--practicing ClassCastException");
          try {
          	((Fish)fishy).m2(); //THROWS ClassCastException
          }
          catch(ClassCastException cce) {
          	System.out.println("ClassCastException caught!!");
          	System.out.println(cce.getMessage());
          }

          System.out.println("--practicing casting");
          Fish pureFish = new Fish();
          pureFish.unDoing();
          pureFish.living();
          ((Animal)pureFish).doing();
          System.out.println(pureFish instanceof Animal);

          System.out.println("--practicing breaking the casting");
          Animal pureAnimal = new Animal();
          try {
          	((Fish)pureAnimal).unDoing();
          }
          catch(ClassCastException cce) {
          	System.out.println("ClassCastException caught!!");
          	System.out.println(cce.getMessage());
          }
     }

    Object m1(){
		return new Object();
	}
	
	void m2(){
		String s = (String) m1();
	}
}
