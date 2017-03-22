
//q65
class Counter
{
   public int startHere = 1;
   public int endHere = 100;
   public static void main(String[] args)
   {
      new Counter().go();
   }
   void go()
   {
      // A
      Thread t = new Thread(a);
      t.start();
   }
}

/*
What block of code can you place at line A above so that this program will count from startHere to endHere?

A.
Runnable a = new Runnable()
{
  public void run()
  {
    for (int i = startHere; i <= endHere; i++){ System.out.println(i); }
  }
};


B.
a implements Runnable
{
  public void run()
  {
    for (int i = startHere; i <= endHere; i++){ System.out.println(i); }
  }
};


C.
Thread a = new Thread()
{
  public void run()
  {
    for (int i = startHere; i <= endHere; i++){ System.out.println(i); }
  }
};

explanation:

A. 
This defines an anonymous Runnable inner class.

B.
The inner class definition is wrong. It should be: class A implements Runnable { ... } Runnable a = new A();
//or in full form
class A implements Runnable
{
  public void run()
  {
    for (int i = startHere; i <= endHere; i++){ System.out.println(i); }
  }
};
Runnable a = new A();

C.
This creates a thread and overrides the run method to do some useful work. 
*/