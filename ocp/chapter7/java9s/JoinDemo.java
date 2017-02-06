

public class JoinDemo {
	public static Thread firstThread;
	public static Thread secondThread;
	public static void main(String[] args) {
		JoinThreads jt = new JoinThreads();
		firstThread = new Thread(jt,"First Thread");
		secondThread = new Thread(jt, "Second Thread");
		firstThread.start();

		while(true){
		State firstThreadStatus = firstThread.getState();
		State secondThreadStatus = secondThread.getState();
		System.out.println(System.nanoTime()+" First Thread status:"+firstThreadStatus);
		System.out.println(System.nanoTime()+" Second Thread Status :"+secondThreadStatus);
		if(firstThreadStatus.equals(State.TERMINATED)&amp;&amp;secondThreadStatus.equals(State.TERMINATED)){
		break;
		}
	}
	// secondThread.start();

	}

}

