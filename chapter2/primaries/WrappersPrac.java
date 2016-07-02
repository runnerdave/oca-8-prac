public class WrappersPrac {
	public static void main(String... a) {
		int i = 1;
		Integer ii = new Integer(1);
		Integer ij = new Integer(1);
		Integer iii = 1;
		Short ss = 1;
		short s = 1;
		Number n = 1;

		System.out.println("test if i and ii are equals with ==:" +(i==ii));
		System.out.println("test if i and ii are equals with equals:" +(ii.equals(i)));
		System.out.println("test if ij and ii are equals with equals:" +(ii.equals(ij)));
		System.out.println("test if ij and ii are equals with ==:" +(ij==ii));
		System.out.println("test if ij and iii are equals with equals:" +(iii.equals(ij)));
		System.out.println("test if ss and iii are equals with equals:" +(iii.equals(ss)));
		System.out.println("test if s and i are equals with ==:" +(i==s));
		//System.out.println("test if ss and ii are equals with ==:" +(ii==ss)); DOES NOT COMPILE
		System.out.println("test if n and ii are equals with ==:" +(ii==n));
		System.out.println("test if ij and n are equals with equals:" +(n.equals(ij)));

		System.out.println("Show usage of ++ on wrapper ii++ (should be 1):" + ii++);

		System.out.println("Show usage of ++ on wrapper ++ii (should be 3):" + ++ii);
	}
}