public class MultiDimensionalArrayPrac {
   public static void main(String[] args){
      int i = 4;
      int ia[][][] = new int[i][i = 3][i];
      System.out.println( ia.length + ", " + ia[0].length+", "+ ia[0][0].length);
      int i3[][][] = new int[4][3][5];
      System.out.println("length should be 4(the first):" + i3.length );
      int i4[][][] = new int[1][3][5];
      System.out.println("length should be 1(the first):" + i4.length );
      System.out.println(" and the second dimension should be 3:" + i4[0].length);
      System.out.println("the very first element should be 0:" + i4[0][0][0]);
      System.out.println("the last element should be 0:" + i4[0][2][4]);
      try {
            System.out.println("it should blow up:" + i4[1][2][4]);
      }
      catch(Exception e) {
            System.out.println("out of bounds: i4[1][2][4]");
      }
   }
}
