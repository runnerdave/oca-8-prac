import java.util.function.*;

import java.awt.Point;

public class ByValuePrac {
	
	static BiConsumer<Integer,Integer> printer = (var1, var2) -> System.out.println("var1:" + var1 + ",var2:" + var2);

	public static void main(String... ss) {
		System.out.println("Prac of by value in java");		

		ByValuePrac bvp = new ByValuePrac();
		int var1 = 1;
		int var2 = 2;
		printer.accept(var1, var2);
		bvp.badSwap(var1,var2);
		printer.accept(var1, var2);

		System.out.println(" ");

		Point pnt1 = new Point(0,0);
		Point pnt2 = new Point(0,0);

		System.out.println("The less tricky bit");	
		printer.accept(pnt1.x, pnt1.y);
		printer.accept(pnt2.x, pnt2.y);
		bvp.lessTricky(pnt1,pnt2);
		printer.accept(pnt1.x, pnt1.y);
		printer.accept(pnt2.x, pnt2.y);

		System.out.println(" ");
		System.out.println("The tricky bit");		
		
		printer.accept(pnt1.x, pnt1.y);
		printer.accept(pnt2.x, pnt2.y);
		bvp.tricky(pnt1,pnt2);
		printer.accept(pnt1.x, pnt1.y);
		printer.accept(pnt2.x, pnt2.y);
	}

	public void badSwap(int var1, int var2)
	{
		int temp = var1;
		var1 = var2;
		var2 = temp;
		System.out.print("INSIDE OF BAD SWAP:");
		printer.accept(var1, var2);
	}

	public void tricky(Point arg1, Point arg2)
	{
		arg1.x = 100;
		arg1.y = 100;
		Point temp = arg1;
		arg1 = arg2;
		arg2 = temp;
		System.out.println("INSIDE OF TRICKY!");
	}

	public void lessTricky(Point arg1, Point arg2)
	{
		arg1.x = 200;
		arg1.y = 200;
		System.out.println("INSIDE OF LESS TRICKY!");
	}	

}

