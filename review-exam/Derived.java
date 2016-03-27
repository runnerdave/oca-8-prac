class Base 
{
    int i = 97;
    float j = 4;
    char k = '0';
    public void amethod()
    {
        System.out.println("Base.amethod()");
    }
            
    Base()
    {
        amethod();
    }

    public float getJ() {
        return j;
    }
}
public class Derived extends Base
{
    int i = -1;
    float j = 2;
        
    public static void main(String argv[])
    {
        Base b = new Derived();
        //Base b = new Base();
        //Derived b = new Derived();
        System.out.println(b.i);
        System.out.println(b.getJ());
        System.out.println((int)b.j);
        System.out.println((int)b.k);
        System.out.println(b.k);
        System.out.print("|");
        System.out.print((char)b.i);
        System.out.println("|");
        b.amethod();
    }
    
    public void amethod()
    {
        System.out.println("Derived.amethod()");
    }

    public float getJ() {
        return j;
    }
}