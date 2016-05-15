public class StaticFunTestClass {
	static StaticFunTestClass ref;
	String[] arguments;

	public static void main(String args[]){
		ref = new StaticFunTestClass();
		ref.func(args);
	}
	public void func(String[] args){
		ref.arguments = args;
	}
}  