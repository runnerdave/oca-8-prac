public class InitTest{
	static int si = 10;
	int  i;
	final boolean bool;
	// { i = 1000; } DOES NOT COMPILE
	{ bool = (si > 5); i = 1000; }
}