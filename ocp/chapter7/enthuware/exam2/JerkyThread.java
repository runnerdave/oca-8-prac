
//Identify the correct statements regarding the following program:

class JerkyThread extends Thread
{
    private int data = 0;
    private boolean done = false;
    public JerkyThread(int x){
        super(); this.data = x;
    }
    public synchronized int getData(){
        return data;   
    }    
    public synchronized boolean isDone(){ return done; }
    public synchronized void run() {
        data += data;
        done = true;
    }
    
    public static void main(String[] args) throws Exception
    {
        JerkyThread[] jta = new JerkyThread[3];
        for(int i=0; i<3; i++) {
            jta[i] = new JerkyThread(i); jta[i].start();
        }
        for(JerkyThread jt : jta) {
            if(jt.isDone()) System.out.println(jt.getData());
        }
    }

}

/*
a. This will throw an exception at run time because run() method can't be synchronized.
b. It will not compile.
c. 0 2 4 is a possible output.
d. 2 0 4 is a possible output.
e. 0 2 2 is a possible output.
f. 2 2 2 is a possible output.

answer c:

explanation

Observe that each JerkyThread has been given a unique value for data i.e. 0, 1, and 2.
 Now, once you start all the 3 threads, any of them may be scheduled to run any time. 
 The main thread loop that prints out the values, prints out the values of thread 1, 
 thread 2, and thread 3 in that sequence. At that time, those threads might be in any 
 state: runnable, running, or finished. In any case, the values will either be same as
  the original data value or data+data. Thus, first value can only be 0 or 0. Second 
  value can be 1 or 2, third value can be 2 or 4.  

Now, observe the line of code: if(
  jt.isDone()) System.out.println(jt.getData()); It prints value only if isDone() 
  returns true. Otherwise, it prints nothing. isDone() returns true only if the 
  statements data += data; and done = true; in the run() method of that instance have 
  been executed. Thus, 0 2 2 is not a possible output although 0 2 is.
*/