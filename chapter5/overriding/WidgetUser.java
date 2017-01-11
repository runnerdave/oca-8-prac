
/* 
What will the following code print when compiled and run?  

a. data
b. big data 
c. nothing
d. not compile

Answer:

This question illustrates the fundamental aspect of overriding, 
which is that it is the actual class of object and not the class of the reference 
type that determines which instance method will be invoked. 
Here, actual class of the object pointed to by w is GoodWidget 
and therefore GoodWidget's doWidgetStuff will be invoked. 
This method does nothing and so nothing is printed.  
Notice that the explict cast to Widget has no impact because the class of the reference is not considered 
while invoking the instance methods at all. 
But you try to access the field directly (or a static method), 
the class of the reference is used. Therefore,          

System.out.println(w.data); //prints data         
System.out.println(((GoodWidget)w).data); //prints big data

*/
class Widget {
	String data = "data";
  	public void doWidgetStuff() {
 	System.out.println(data);
	}
}

class GoodWidget extends Widget{
 	String data = "big data";
	public void doWidgetStuff() { }
}

public class WidgetUser{
	public static void main(String[] args) {
	Widget w = new GoodWidget();
	((Widget)w).doWidgetStuff();
	}
}