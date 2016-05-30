public class Rope {
	public static int LENGTH = 5;
	static {
		LENGTH += 10;
	}

	{
		LENGTH += 2;
	}

    int width = 2;
	public static void swing(){
		System.out.println("I am swinging" + LENGTH);
	}
    public static void swing(int times){
        LENGTH++;
        System.out.println("multiply " + times + " times, new LENGTH " + (times*LENGTH) );
    }
	public Rope(){
		System.out.println("created");
	}
    public void Rope(){
        System.out.println("only the void method call");
    }

}
