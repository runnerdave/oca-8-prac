import java.util.function.*;
public class ByValuePrac {
	
	public static void main(String... ss) {
		System.out.println("Prac of by value in java");

		BiConsumer<Integer,Integer> printer = (var1, var2) -> System.out.println("var1:" + var1 + ",var2:" + var2);

		ByValuePrac bvp = new ByValuePrac();
		int var1 = 1;
		int var2 = 2;
		printer.accept(var1, var2);
		bvp.badSwap(var1,var2);
		printer.accept(var1, var2);
	}

	public void badSwap(int var1, int var2)
	{
		int temp = var1;
		var1 = var2;
		var2 = temp;
		System.out.println("INSIDE OF BAD SWAP: var1:" + var1 + ",var2:" + var2);
	}

}

