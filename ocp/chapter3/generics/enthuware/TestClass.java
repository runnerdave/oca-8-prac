import java.util.*;

class Booby { }
class Dooby extends Booby { }
class Tooby extends Dooby { }

public class TestClass {
    Booby b = new Booby();
    Tooby t = new Tooby();

    public void addData1(List<? super Dooby> dataList) {
        //box1
    }

    public void addData2(List<? extends Dooby> dataList) {
        //box2
    }
}

/*
fill the boxes and compile with the following options:

dataList.add(t);

dataList.add(b);

b = dataList.get(0);

t = dataList.get(0);

explanation:

1. addData1(List<? super Dooby> dataList) : 

This means that dataList is a List whose elements are of a class that is either Dooby or a super class of Dooby. 
We don't know which super class of Dooby. Thus, if you try to add any object to dataList, it has to be a assignable to Dooby. 
Thus, dataList.add(b); will be invalid because b is not assignable to Dooby. 
Further, if you try to take some object out of dataList, that object will be of a class that is either Dooby or a Superclass of Dooby. 
Only way you can declare a variable that can be assigned the object retrieved from dataList is Object obj. 
Thus, t = dataList.get(0); and b = dataList.get(0); are both invalid.   

2. addData2(List<? extends Dooby> dataList) 

This means that dataList is a List whose elements are of a class that is either Dooby or a subclass of Dooby. 
Since we don't know which subclass of Dooby is the list composed of, there is no way you can add any object to this list.  
If you try to take some object out of dataList, that object will be of a class that is either Dooby or a subclass of 
Dooby and thus it can be assigned to a variable of class Dooby or its superclass.. 
Thus, t = dataList.get(0) ; is invalid.

*/