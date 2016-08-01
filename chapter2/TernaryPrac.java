public class TernaryPrac {

	static public void main(String... g) {

		System.out.println("===========Practicing short circuits==============");
		int i = 1;
		int j = 2;
		int z = 0;

		z = (z==0) ? i++ : j++;

		System.out.println("z:" + z);
		System.out.println("i:" + i);
		System.out.println("j:" + j);

		System.out.println((z==0) ? i++ : j++);
		
		System.out.println("z:" + z);
		System.out.println("i:" + i);
		System.out.println("j:" + j);

		System.out.println("===========Practicing numeric promotion==============");

		float f = 1.2f;
		double d = 1.8;
		System.out.println((f<d) ? f : d);

	}

}