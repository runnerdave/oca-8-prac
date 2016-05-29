public class Operators{
	public static int operators(){
		int x1 = -4;
		int x2 = x1--;
		int x3 = ++x2;
		if(x2 > x3){
			--x3;
		}else{
			x1++;
		}
 		return x1 + x2 + x3;
	}

	public static void main(String[] args) {
		System.out.println(operators());
		System.out.println("mod example 1%2:" + (1%2));
		System.out.println("mod example 2%3:" + (2%3));
		System.out.println("mod example 2%7:" + (2%7));
		System.out.println("mod example 12.1%2:" + (12.1%2));
		System.out.println("mod example 12.1/2:" + (12.1/2));
		System.out.println("div example 1/2:" + (1/2));
		System.out.println("div example 1/3:" + (1/3));
		System.out.println("div example 4/3:" + (4/3));
		System.out.println("div example 3/4:" + (3/4));
	}
}
