public class WrappersPrac {
	public static void main(String... a) {
		int i = 1;
		Integer ii = new Integer(1);
		Integer ij = new Integer(1);
		Integer iii = 1;
		Short ss = 1;
		short s = 1;

		System.out.println("test if i and ii are equals with ==:" +(i==ii));
		System.out.println("test if i and ii are equals with equals:" +(ii.equals(i)));
		System.out.println("test if ij and ii are equals with equals:" +(ii.equals(ij)));
		System.out.println("test if ij and ii are equals with ==:" +(ij==ii));
		System.out.println("test if ij and iii are equals with equals:" +(iii.equals(ij)));
		System.out.println("test if ss and iii are equals with equals:" +(iii.equals(ss)));
		System.out.println("test if s and i are equals with ==:" +(i==s));
	}
}