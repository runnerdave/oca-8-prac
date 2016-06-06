

class Super { static String ID = "QBANK"; }

class Sub extends Super{
	static String tt;
   static { System.out.print("In Sub"); }
}

public class TestStaticInitializer {
   public static void main(String[] args){
      System.out.println(Sub.ID);
      Sub s = new Sub();
      String ss = s.ID;
      s.tt = "now!";
      //System.out.println(ss + "|" + s.tt); //uncomment this line and only now the static initializer will be called
   }
}