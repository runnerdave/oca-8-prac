public class GenericMethodPrac {
	public static void main(String... a) {
		GenericMethodPrac.sink(new Object());
		GenericMethodPrac.sink(new String("dd"));
		GenericMethodPrac.<String>sink(new String("dd2"));
		GenericMethodPrac.sink(2);

		System.out.println(GenericMethodPrac.identity("ss"));
		System.out.println(GenericMethodPrac.<String>identity("ss2"));
		System.out.println(GenericMethodPrac.identity(3));
		System.out.println(GenericMethodPrac.<Integer>identity(3));

		GenericMethodPrac gmp = new GenericMethodPrac();
		System.out.println(gmp.identityInstance("using instance method"));
	}

	public static <T> void sink(T t) {
		System.out.println("sink method called with:" + t.toString());
	}

	public static <T> T identity(T t) { return t; }

	public <T> T identityInstance(T t) { return t; }
}