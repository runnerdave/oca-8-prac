import java.util.function.*;
import java.util.*;

public class q9 {
    public static void main(String... args) {

        //What will the following code print?

        List<String> vowels = new ArrayList<String>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");
        Function<List<String>, List<String>> f = list->list.subList(2, 4);
        f.apply(vowels);
        vowels.forEach(System.out::print);

        /*
        There is no problem with the code. The List.subList method returns a view backed by the original list. It doesn't change the existing list. 
        Therefore, when you print the elements from the original list after calling subList, you will see all the elements of the original list.  
        Remember that, however, if you modify the sub list, the changes will be visible in the original list. 

        For example, the following will print aeioxu: 
        List<String> view = f.apply(vowels);//get a view backed by the original list 
        view.add("x");//modify the view 
        vowels.forEach(System.out::print); //updates visible in original list
        */

        System.out.println();
        System.out.println("== subList print out==");
        List<String> view = f.apply(vowels);
        System.out.println(view);
        view.add("x");//modify the view 
        vowels.forEach(System.out::print);

    }
}