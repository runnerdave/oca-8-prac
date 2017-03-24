import java.util.function.*;

// q89 test 5
public class Q89 { 
    public static int operate(IntUnaryOperator iuo){ 
        return iuo.applyAsInt(5); 
    }  

    public static void main(String[] args) {  
        IntFunction<IntUnaryOperator> fo = a->b->a-b;//1  
        int x = operate(fo.apply(20)); //2 
        System.out.println(x); 
    } 
}

/*
What will the following code print when compiled and run?

a. Compilation error at //1

b. Compilation error at //2

c. 15

d. -15

e. 20

f. Exception at runtime

Explanation:

The lambda expression a->b->a-b looks complicated but it is actually simple if you group it like this: a->(b->a-b);  

1. IntFunction is a functional interface that takes an int and returns whatever it is typed to. 
Here, the IntFunction is typed to IntUnaryOperator. Therefore, IntFunction<IntUnaryOperator> will take in an int and return IntUnaryOperator. 
The general form of a lambda expression that captures IntFunction would be x->line of code that returns the correct return type i.e. IntUnaryOperator, 
in this case; where x is an int.  
Now, if you look at fo = a->b->a-b;, a is the argument variable of type int (because it is being used to capture IntFunction) 
and b->a-b forms the method body of the IntFunction. b->a-b must somehow return an IntUnaryOperator for fo = a->b->a-b; to work.   

2. IntUnaryOperator is a functional interface that takes in an int and returns another int. It cannot be typed to anything else because
 both the input and the output are already defined to be int. The general form of a lambda expression that captures IntUnaryOperator 
 would be y->line of code that returns an int; where y is an int.  

 Now, in the case of b->a-b; you can see that b is the argument variable and a-b is the method body. For a-b to capture IntUnaryOperator, 
 a must already be defined and it must be an int. Only then will a-b return an int (which is required to capture IntUnaryOperator). 
 That is indeed the case because a is already defined as the argument variable of the encompassing lambda expression and is available 
 for use within the method body of that expression.   

3. So basically, when you call fo.apply(20), you are setting a to 20. 
Therefore, fo.apply(20) returns an IntUnaryFunction that returns 20-b, where b is the argument passed to the IntUnaryFunction. 
When you call iuo.applyAsInt(5); b is being set to 5. Therefore iuo.applyAsInt(5) will return 20-5 i.e. 15.
*/
