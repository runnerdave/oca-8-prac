//exam 2 q39

import java.util.*; 

public class Q39 {
        public < E extends CharSequence > Collection < E > 
            getWordsStartingWith( Collection< E > input , char ch ) 
        {
            Collection<E> returnValue = new ArrayList< E >();
            int len = input.size();
            for(E e : input) {
                if(e.charAt(0) == ch) returnValue.add(e); 
            }
            return returnValue;
        }  
    
        public void checkIt() { 
            List<String> a = new ArrayList<String>(); a.add("apple"); a.add("cherry"); 
            Set<StringBuffer> b = new HashSet<StringBuffer>(); b.add( new StringBuffer("pineapple")); 
            Collection<String> ac = getWordsStartingWith(a, 'a'); 
            Collection<StringBuffer> bc = getWordsStartingWith(b, 'b'); 
        }  
        
        public static void main(String[] args) {
            new Q39().checkIt(); 
        } 
} 

/*
1. Observe that getWordsStartingWith() method is using charAt() method on the elements. 
Also observe that the checkIt() method is passing a collection of Strings as well as StringBuffer. 
Thus, the only way to specify the type of argument for getWordsStartingWith method is to specify that it extends CharSequence. 
Therefore, the type specification will be <E extends CharSequence>.  

2. getWordsStartingWith() method takes elements from the input collection and adds them to returnValue collection. 
Since it does not know the type of elements in 'input' the only way to specify the output collection is to use the same type (E) as the input. 
Thus, the return type should be  Collection < E >  

3. You cannot instantiate a Collection because it is an abstract class. So you must instantiate ArrayList with the same type (E).  

4. When the checkIt() method passes a collection of Strings, the getWordsStartingWith() method is typed with String and its return value will be typed to Collection<String>. Therefore, in checkIt() method, the type of variable ac should be Collection<String>. Same logic applies to bc, where the type of bc should be Collection<StringBuffer>.
*/
