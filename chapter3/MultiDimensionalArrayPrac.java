import java.util.Arrays;
public class MultiDimensionalArrayPrac {
   public static void main(String[] args){
      int i = 4;
      int ia[][][] = new int[i][i = 3][i];
      System.out.println( ia.length + ", " + ia[0].length+", "+ ia[0][0].length);
      int i3[][][] = new int[4][3][5];
      System.out.println("new int[4][3][5] length should be 4(the first):" + i3.length );
      int i4[][][] = new int[1][3][5];
      System.out.println("new int[1][3][5] - length should be 1(the first):" + i4.length );
      System.out.println(" and the second dimension should be 3:" + i4[0].length);
      System.out.println("the very first element should be 0:" + i4[0][0][0]);
      System.out.println("the last element should be 0:" + i4[0][2][4]);
      try {
            System.out.println("it should blow up:" + i4[1][2][4]);
      }
      catch(Exception e) {
            System.out.println("new int[1][3][5] - out of bounds: i4[1][2][4]");
      }
      System.out.println("new int[1][3][5] to string:" + Arrays.deepToString(i4));

      double daaa[][][] = new double[3][][];
      double d = 100.0;
      double[][] daa = new double[1][1];

      daaa[0] = daa;

      daa = daaa[0];
      System.out.println("daaa[0][0]:" + Arrays.toString(daaa[0][0]));



      int[][][] a = {{{1,2,3},{1,2,3}}};

      System.out.println("a[0][0]:" + Arrays.toString(a[0][0]));

      System.out.println("==========2x2 practice========");      

      int i5[][] = new int [2][2];
      System.out.println("initial values:" + Arrays.deepToString(i5));
      i5[0][1] = 1;
      System.out.println("i5[0][1] = 1:" + Arrays.deepToString(i5));
      i5[1][0] = 1;
      System.out.println("i5[1][0] = 1:" + Arrays.deepToString(i5));

      System.out.println("==========5x2 practice========");      

      int i6[][] = new int [2][5];
      System.out.println("initial values:" + Arrays.deepToString(i6));
      i6[1][3] = 1;
      System.out.println("i6[1][3] = 1:" + Arrays.deepToString(i6));      

   }
}
