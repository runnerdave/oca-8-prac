//this exercise ask what are the necessary imports to make the class compile
//therefore originaly no import was in place
import java.util.*;
import static java.util.Collections.*;
class ListHelper {
public List <String> copyAndSortList(List <String> original) {
List <String> list = new ArrayList <String>(original); sort(list);
return list;
} }
