public class SwitchOddities {
	
	public static void main(String... args) {
		int i = 1;
		System.out.println("Switch with no breaks prints default and everything without break afterwards");
		switch(i) {
			case 11:
				System.out.println("11");
			case 1:
				System.out.println(1);
			default:
				System.out.println("none");
			case 111:
				System.out.println(111);
			case 1111:
				System.out.println(1111);
		}

		System.out.println("Switch with breaks prints only the match");
		switch(i) {
			case 11:
				System.out.println("11");
				break;
			case 1:
				System.out.println(1);
				break;
			default:
				System.out.println("none");
				break;
			case 111:
				System.out.println(111);
				break;
		}

		System.out.println("Switch with mixed breaks prints match, default and everything without break afterwards");
		switch(i) {
			case 11:
				System.out.println("11");
			case 1:
				System.out.println(1);
			default:
				System.out.println("none");
			case 111:
				System.out.println(111);
				break;
			case 1111:
				System.out.println(1111);
		}

		System.out.println("Switch with mixed breaks prints default and everything without break afterwards");
		i = 4;
		switch(i) {
			case 11:
				System.out.println("11");
			case 1:
				System.out.println(1);
			default:
				System.out.println("none");
			case 111:
				System.out.println(111);
				break;
			case 1111:
				System.out.println(1111);
		}

		System.out.println("Switch with mixed breaks without match and without default prints nothing");
		switch(i) {
			case 11:
				System.out.println("11");
			case 1:
				System.out.println(1);
			case 111:
				System.out.println(111);
				break;
			case 1111:
				System.out.println(1111);
		}

	}
}