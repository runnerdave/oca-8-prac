public class Deer {     
     static int count;     
     static { count = 0; }          
     Deer() {       
          count++;
     }         
     public static void main(String[] args) {       
          count++;       
          Deer mother = new Deer();       
          Deer father = new Deer();       
          Deer fawn = new Deer();       
          System.out.println(father.count);     
     }
} 
