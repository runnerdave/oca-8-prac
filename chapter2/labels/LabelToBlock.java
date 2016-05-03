//shows that a label can be applied to a single block but the scope is not more than that block

public class LabelToBlock {
	void crazyLoop(){
		int c = 0;
		JACK: while (c < 8){
			JILL: System.out.println(c);
			if (c > 3) break JILL; else c++;
			//uncomment the following line for the file to compile
			//if (c > 3) break; else c++;
		}
		System.out.println(c);
	}

	public static void main(String... a) {
		LabelToBlock lb = new LabelToBlock();
		lb.crazyLoop();
	}

}