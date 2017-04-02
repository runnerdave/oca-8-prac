/*Which of the following are true statements about the following code? 
(Choose all that apply.)
A.The code prints Roar! three times.h
B. Line 4 does not compile.
C. Line 5 does not compile.
D. Line 10 does not compile.
E. A different line does not compile.
F. A runtime exception is thrown because an inner class is declared in a loop.
*/
public class OuterWithLoop {
     public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
           class Inner {//4
              public static void print() {//5
                 System.out.println("Roar!");
           } 
        } 
     }
    new Inner().print();//10
} }

/*
C,D
A local inner class is not allowed to have static methods. 
It also goes out of scope like regular local variables. 
Inner is scoped to be inside the for loop. It is legal to declare an inner class 
inside a loop as long as it is referenced only inside that loop.*/