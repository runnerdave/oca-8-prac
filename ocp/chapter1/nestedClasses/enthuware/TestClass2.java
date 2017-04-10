
//Which of the given options if put at //1 will correctly instantiate objects of various classes defined in the following code?


public class TestClass2
{
   public class A{
   }
   public static class B {
   }
   public static void main(String args[]){
      class C{
      }
      //1
      new TestClass2().new A();
      new TestClass2().new B();
      new TestClass2.A();
      new C();
      new TestClass2.C();
   }
}

/**
a. new TestClass2().new A();
b. new TestClass2().new B();
c. new TestClass2.A();
d. new C();
e. new TestClass2.C();

explanation:
class A is not static inner class of TestClass. So it cannot exist without an outer instance of TestClass. 
So, option 1 is the right way to instantiate it. class B is static inner class and can be instantiated like this: new TestClass.B(). 
But new TestClass().new B() is not correct. Although not related to this question, unlike popular belief, 
anonymous class can never be static. Even if created in a static method.
*/
