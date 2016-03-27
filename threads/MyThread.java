public class MyThread implements Runnable 
{ 
    String myString = "Yes "; 
    public void run() 
    { 
        this.myString = "No "; 
    } 
    public static void main(String[] args) 
    { 
        MyThread t = new MyThread(); 
        new Thread(t).start(); 
        for (int i=0; i < 10; i++) 
        System.out.print(t.myString); 
    } 
}