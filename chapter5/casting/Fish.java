public class Fish extends Animal implements Reaction {
     public void unDoing() {
          System.out.println("not doing it");
     }

     public static void main(String... args) {
          Animal fishy = new Fish();
          ((Fish)fishy).unDoing();
          new Fish().unDoing();
     }
}
