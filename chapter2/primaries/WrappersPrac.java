public class WrappersPrac {
	public static void main(String... a) {
		int i = 1;
		Integer ii = new Integer(1);
		Integer ij = new Integer(1);

		System.out.println("test if i and ii are equals with ==:" +(i==ii));
		System.out.println("test if i and ii are equals with equals:" +(ii.equals(i)));
		System.out.println("test if ij and ii are equals with equals:" +(ii.equals(ij)));
		System.out.println("test if ij and ii are equals with ==:" +(ij==ii));
	}
}