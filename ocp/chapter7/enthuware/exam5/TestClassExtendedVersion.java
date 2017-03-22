class A extends Thread
{
    static protected int i = 0;
    public void run()
    {
        for(; i<5; i++)
        {
             System.out.println("Hello "+i);
            try{ Thread.sleep(100); }catch(Exception e){}
        }
    }
}
public class TestClassExtendedVersion extends A
{
    public void run()
    {
        for(; i<5; i++)
        {
            System.out.println("World "+i);
            try{ Thread.sleep(100); }catch(Exception e){}
        }


    }
    public static void main(String args [])
    {
        Thread t1 = new A();
        Thread t2 = new TestClassExtendedVersion();
        t2.start(); t1.start();
    }
}