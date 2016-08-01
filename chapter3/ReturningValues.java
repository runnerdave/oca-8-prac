public class ReturningValues {
     public static void main(String[] args) {

          int number = 1;// 1

          String letters = "abc";// abc

          number(number);// 1

          //letters = letters(letters);// abcd
          letters(letters);// abcd

          System.out.println(number + letters);// 1abcd

          System.out.println(number + lettersBreakImmutability(letters));          
     }
     
     public static int number(int number) {

          number++;

          return number;
     }

     public static String letters(String letters) {

          letters += "d";

          return letters;
     }

     public static String lettersBreakImmutability(String letters) {

          letters = letters + "d";
          System.out.println("letters inside of method:" + letters);
          return letters;
     }
}
