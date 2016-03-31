public class StringBuilderPrac {
	
	public static void main(String... a) {

		StringBuilder sb = new StringBuilder(10);
		System.out.println(sb);//prints empty line
		System.out.println(sb.capacity());//prints 10
		StringBuilder sb1 = new StringBuilder("corriendo!");
		System.out.println("substring 0,4 of corriendo:" + sb1.substring(0,4));//should return corr
		System.out.println("substring 5,length of corriendo:" + sb1.substring(4,sb1.length()));//should return iendo
		System.out.println("charAt 4 of corriendo:" + sb1.charAt(4));//should return i
		System.out.println("indexOf 4 of corriendo:" + sb1.indexOf(("i")));//should return 4
		System.out.println("should insert \u00A1 at the start:" + sb1.insert(0,"\u00A1"));//should insert ¡ at the start
		System.out.println("should replace \u00BF at the start and ? at the end:" 
							+ sb1.replace(0, 1,"\u00BF")
								 .replace(sb1.length()-1, sb1.length(),"?"));//should replace exclamation with question
		try {
			System.out.println(sb1.charAt(sb1.length()));//should throw index out of bounds exception
		}
		catch(IndexOutOfBoundsException ioob) {
			System.out.println(ioob.getMessage());
			//ioob.printStackTrace();
		}
	}

}