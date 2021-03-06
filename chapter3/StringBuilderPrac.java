public class StringBuilderPrac {
	
	static public void main(String... a) {

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

		System.out.println("==practicing method chaining==");
		System.out.println("BEFORE contents of sb:" + sb);
		sb.append("a").append("bcd").insert(2, "a");
		/*
		same as:
		sb.append("a"); 
		sb.append("asdf"); 
		sb.insert(2, "asdf")
		*/
		System.out.println("AFTER contents of sb:" + sb);

		//NOT VALID sb.append("a").substring(0, 4).insert(2, "asdf");  
		//The following is valid though:  
		String str = sb.append("a").insert(2, "asdf").substring(0, 4);
		System.out.println("contents of str:" + sb);

		sb.append(false);
		System.out.println("append false contents of sb:" + sb);

		System.out.println("==practicing method insert==");
		System.out.println("BEFORE contents of sb:" + sb);
		sb.insert(1, "INSERTED");

		System.out.println("AFTER contents of sb:" + sb);

		System.out.println("==practicing method append with offset==");
		System.out.println("BEFORE contents of sb:" + sb);
		sb.append("INSERTED", 1, 2);

		System.out.println("AFTER contents of sb:" + sb);


		System.out.println("==practicing method delete and clear (no method clear)==");
		System.out.println("BEFORE contents of sb:" + sb);
		
		sb.deleteCharAt(3);

		System.out.println("AFTER deletion of index 3 contents of sb:" + sb);


		sb.delete(0, sb.length());
		System.out.println("AFTER full delete contents of sb:" + sb);

		sb.append("12345678");
		System.out.println("AFTER populating it with 12345678 contents of sb:" + sb + "|length:" + sb.length());	
		
		sb.setLength(5);
		System.out.println("AFTER setting the length to only 5:" + sb + "|length:" + sb.length());	

		sb.setLength(10);
		System.out.println("AFTER setting the length to 10:" + sb + "|length:" + sb.length());

		System.out.println("==practicing method creation of anonymous SB using + ==");
		System.out.println(new StringBuilder("SB") + "-with this attached");
	}

}