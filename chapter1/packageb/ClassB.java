package packageb;
import packagea.ClassA;
public class ClassB {
     static int instance;
     public static void main(String[] gs){
	     int tres = 3;
	     double localVar = 0x100;

	     String _3iñrtyu = "hhh";
	     double $0jjj = 2.3;
	     String $ = "hola";
	     System.out.println(tres); 
	     System.out.println(_3iñrtyu); 
	     System.out.println($0jjj); 
	     System.out.println(instance); 
	     System.out.println("localVar:"); 
	     System.out.println(localVar); 
	     System.out.println($); 
	     ClassA a;
	     System.out.println("Got it");
	     System.out.println(Short.MAX_VALUE);
	     System.out.println("###########SUM#############");
		double x = 23.7;
		float  y = 1.3F;
		System.out.println(x+y);	
		long z = 21474836470L;
	     System.out.println("###########IF#############");
		int xx = 12;
		int yy = 1;
		//int zz = xx > 13 ? xx++ : yy++;
		if (xx > 13) {
			xx++;
		} else {
			yy++;
		}
		System.out.println(xx + " " + yy); 
	     System.out.println("########### switch #############");
		xx = 11;
		switch (xx) {
			default:
			System.out.println("12");
			case 0:
			System.out.println("0");
			case 13:
			System.out.println("13");
		}
     }
}
