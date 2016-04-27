public class PrimitivesByValuePrac {
	
	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		ByValuePrac.printer.accept(i,j);
		System.out.println("before call to test()");
		test(i++,++j);
		System.out.println("after call to test()");
		ByValuePrac.printer.accept(i,j);
	}

	public static void test(int ii, int jj) {
		ByValuePrac.printer.accept(ii,jj);
		ByValuePrac.printer.accept(ii++,++jj);
	}
}