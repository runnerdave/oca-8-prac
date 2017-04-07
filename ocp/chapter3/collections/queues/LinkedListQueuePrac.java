import java.util.*;

public class LinkedListQueuePrac {
    public static void main(String... ars) {
       //What is the result of the following statements?
        Queue<Integer> q = new LinkedList<>();
        q.add(new Integer(6));
        q.add(new Integer(6));
        // System.out.println(q.size() + " " + q.contains(6L));     
        System.out.println(q.size() + " " + q.contains("u"));     
    }    
}



/*
  A.1 false
  B.1 true
  C.2 false
  D.2 true
  E.The code does not compile.
  F.A runtime exception is thrown.
*/