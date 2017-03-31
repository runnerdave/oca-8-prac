public class WhatisIt {
   interface Furry { }
   class Chipmunk  { }   
   class FurryChipmunk implements Furry { }   
   public static void main(String[] args) {
         Chipmunk c = new Chipmunk();      
         int result = 0;      
         if (c instanceof Furry) result += 1;      
         if (c instanceof Chipmunk) result +=2;      
         if (null instanceof FurryChipmunk) result += 4;      
         System.out.println(result);  
   } 
}
/*---APPARENTLY it needds a n instance of WhatIsIt to compile because the inner classes should be static*/