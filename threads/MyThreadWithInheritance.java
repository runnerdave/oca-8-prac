public class MyThreadWithInheritance extends Thread {

  public void run() {
    int counter = 0;
    while (counter < 5) {
      System.out.println("running " + counter);
      counter++;
    }
  }

  public static void main(String[] args) {
    MyThreadWithInheritance demo = new MyThreadWithInheritance();
    demo.start();
  }
}