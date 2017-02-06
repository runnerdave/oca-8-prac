public class JoinThreads implements Runnable {

	@Override
	public void run() {
		//for(int i =0 ; i&lt;100;i++){
		System.out.println(System.nanoTime()+" Current Thread:"+Thread.currentThread().getName()+" is at the beginning");

		//}
		if(Thread.currentThread().getName().equals("First Thread")){
			try {
				System.out.println(System.nanoTime()+" Inside the join condition");
				JoinDemo.secondThread.start();
				JoinDemo.secondThread.join();
				//Getting the first threads state

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		System.out.println(System.nanoTime()+" Current Thread:"+Thread.currentThread().getName()+" is at the end");
	}

}