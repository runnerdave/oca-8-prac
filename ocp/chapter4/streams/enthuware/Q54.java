import java.util.*;
import java.util.stream.*;

//exam 5 q54

class Student {
    public static enum Grade{ A, B , C, D, F}
    private String name; 
    private Grade grade; 

    public Student(String name, Grade grade){
        this.name = name; 
        this.grade = grade; 
    }

    public String toString(){
        return name+":"+grade; 
    } 
    
    public String getName() {
        return this.name;
    }

    public Grade getGrade() {
        return this.grade;
    }
}  

//What can be inserted in the code below so that it will print:
// {C=[S3], A=[S1, S2]}   

public class Q54 {
    public static void main(String... args) {
        List<Student> ls = Arrays.asList(new Student("S1", Student.Grade.A), new Student("S2", Student.Grade.A), new Student("S3", Student.Grade.C)); 
        //INSERT CODE HERE 
        //uncomment the option:
        
        //a
        // Map<Student.Grade, List<Student>> grouping = ls.stream().collect(
        //  Collectors.groupingBy(Student::getGrade),
        //  Collectors.groupingBy(Student::getName, Collectors.toList()))); 

        //b
        // Map<Student.Grade, List<String>> grouping = ls.stream().collect(
        //     Collectors.groupingBy(Student::getGrade, 
        //     Collectors.groupingBy(Student::getName, Collectors.toList())));

        //c
        Map<Student.Grade, List<String>> grouping = ls.stream().collect(
         Collectors.groupingBy(Student::getGrade, 
         Collectors.mapping(Student::getName, Collectors.toList())));

        //d
        // Map<Student.Grade, List<String>> grouping = ls.stream().collect(
        //     Collectors.groupingBy(Student::getGrade, 
        //     Collectors.mapping(Student::getName)));


        System.out.println(grouping);   
    }
}

/*
explanation:
a.
Invalid arguments to the collect method.  
Remember that Stream has only two overloaded collect methods 
    - one that takes a Collector as an argument and another one that takes a Supplier, BiConsumer, and BiConsumer. 
    In this option, it is trying to pass two Collectors to the collect method. Therefore, it will not compile.  
    
    1. public <R,A> R collect(Collector<? super T,A,R> collector) Performs a mutable reduction operation on the elements of this stream using a Collector. 
    A Collector encapsulates the functions used as arguments to Stream.collect(Supplier, BiConsumer, BiConsumer), 
    allowing for reuse of collection strategies and composition of collect operations such as multiple-level grouping or partitioning.  

    2.public <R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)
     Performs a mutable reduction operation on the elements of this stream. A mutable reduction is one in which the reduced value is a mutable result container, 
     such as an ArrayList, and elements are incorporated by updating the state of the result rather than by replacing the result. 

b.
The right hand side of = is actually okay from a compilation perspective. 
It is trying to group the elements of the stream by Grade and then it is again trying to groups the elements of each grade by name. 
So technically, the return type of this expression would be: Map<Student.Grade, Map<String, List<Student>>> grouping = ...  
Even if you change the left hand side declaration as described, it will only print 
{C={S3=[S3:C]}, A={S1=[S1:A], S2=[S2:A]}}, which is not what is required by the question.

c.
This code illustrates how to cascade Collectors. 
Here, you are first grouping the elements by Grade and then collecting each element of a particular grade into a list after mapping it to a String. 
This will produce the required output.

d.
Collectors.mapping method requires two arguments - the first argument must be a Function that maps one element type into another 
(here, you are mapping Student to String, which is good), and the second argument must be an appropriate Collector 
in which you can hold the result (here, this argument is missing). Therefore, it will not compile.
*/
