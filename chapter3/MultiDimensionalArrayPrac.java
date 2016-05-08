public class MultiDimensionalArrayPrac {
   public static void main(String[] args){
      int i = 4;
      int ia[][][] = new int[i][i = 3][i];
      System.out.println( ia.length + ", " + ia[0].length+", "+ ia[0][0].length);
      int i3[][][] = new int[4][3][5];
      System.out.println("length should be 3(the first):" + i3.length );
   }
}
