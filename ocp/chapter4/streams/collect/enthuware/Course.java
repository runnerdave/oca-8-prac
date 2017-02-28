import java.util.*;
import java.util.stream.Collectors;
//Given:

public class Course{
    private String id;
    private String category;

    public Course(String id, String category){
        this.id = id; this.category = category;
    }
    
    public String toString(){
        return id+" "+category;
    }

    public String getCategory(){
        return category;
    }

    public static void main(String... args) {
        //What will the following code print?

        List<Course> s1 = Arrays.asList(
                new Course("OCAJP", "Java"),
                new Course("OCPJP", "Java"),
                new Course("C#", "C#"),
                new Course("OCEJPA", "Java")
        );

        s1.stream()
               .collect(Collectors.groupingBy(c->c.getCategory()))
               .forEach((m, n)->System.out.println(n));

        //uncomment the lines below to display the map
        // System.out.println(s1.stream()
        //        .collect(Collectors.groupingBy(c->c.getCategory())));
    }
    
}


