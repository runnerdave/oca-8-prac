
//q53 exam 3
//Consider the following code:

class Outsider
{
   public class Insider{ }
}
public class TestClass
{
   public static void main(String[] args)
   {
       Outsider os = new Outsider();
       // 1 insert line here
    }
}

/* Which of the following options can be inserted at //1?

a. Insider in = os.new Insider(); 
b. os.Insider in = os.new Insider();
c. Outsider.Insider in = os.new Insider();
d. Insider in = Outsider.new Insider(); 

answer c:

a is wrong because You cannot refer to Insider class directly (unless you import the inner class using import statement such as import p1.Outsider.*; where p1 is the package name).  In the given code, for all purposes, the name of the class is Outsider.Insider. Therefore, it should be referred to as: Outsider.Insider in = os.new Insider();

b is wrong because os.Insider implies that Insider class is in package os, which is not the case.

c is right because Since Insider is not a static class, it must have an associated outer class instance.

d You cannot refer to Insider class directly. You must use Outsider.Insider to declare the type of variable in.   Outsider.new Insider() is wrong as well because Insider is not static. Further, even if Insider were static, the syntax to instantiate it would be: new Outsider.Insider().
*/

