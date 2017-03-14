
//Q40 What will the following code print when run?

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    // static Path p1 = Paths.get("c:\\a\\b\\c");//works for windows
    static Path p1 = Paths.get("/a/b/c");//works for linux
    
    public static String getValue(){
        String x = p1.getName(1).toString();
        String y = p1.subpath(1,2).toString();
        return x+" : "+y;
    }
    
    public static void main(String[] args) {
        System.out.println(getValue());
        //my own stuff
        System.out.println(getRoot());
    }

    //myown stuff:
    public static String getRoot() {
        return p1.getRoot().toString();
    }
}
