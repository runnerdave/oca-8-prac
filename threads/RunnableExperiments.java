public class RunnableExperiments implements Runnable {

  static Thread thread;

  public void run() {
    int counter = 0;
    System.out.println("thread is alive? (in run method): " + thread.isAlive());
    while (counter < 5) {
      System.out.println("running " + counter);
      counter++;
    }
  }

  public void start() {
    thread = new Thread(this);
    System.out.println("thread is alive? (in start method): " + thread.isAlive());
    thread.start();
  }
  
  public static void main(String[] args) {
    RunnableExperiments demo = new RunnableExperiments();
    demo.start();
    System.out.println("thread name: " + thread.getName());
    System.out.println("thread toString: " + thread.toString());
    System.out.println("thread state: " + thread.getState());
    System.out.println("thread is alive: " + thread.isAlive());
  }
} 