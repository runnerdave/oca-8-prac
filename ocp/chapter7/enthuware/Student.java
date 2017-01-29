
//Consider the following code:
public class Student {
    private Map<String, Integer> marksObtained = new HashMap<String, Integer>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    public void setMarksInSubject(String subject, Integer marks){
        // 1 INSERT CODE HERE
        try{
            marksObtained.put(subject, marks);
        }finally{
            // 2 INSERT CODE HERE
        }

    }
    public double getAverageMarks(){
       // valid code that computes average
    }
}

 /*What should be inserted at //1 and //2?
    a.  lock.writeLock().acquire(); 
        and lock.writeLock().release();

    b.  lock.writeLock().lock(); 
        and lock.writeLock().unlock();

    c.  lock.acquire(); 
        and lock.release();

    d.  lock.readLock().lock(); 
        and lock.readLock().unlock();

    answer:

    b.

    explanation:

    From a ReadWriteLock, you can get one read lock (by calling lock.readLock() ) and one write lock (by
     calling lock.writeLock() ). Even if you call these methods multiple times, the same lock is
      returned. A read lock can be locked by multiple threads simultaneously (by calling 
      lock.readLock().lock() ), if the write lock is free. If the write lock is not free, a read lock 
      cannot be locked. The write lock can be locked (by calling lock.writeLock().lock() ) only by only 
      one thread and only when no thread already has a read lock or the write lock. In other words, if 
      one thread is reading, other threads can read, but no thread can write. If one thread is writing, 
      no other thread can read or write.  Methods that do not modify the collection (i.e. the threads 
      that just "read" a collection) should acquire a read lock and threads that modify a collection 
      should acquire a write lock.  The benefit of this approach is that multiple reader threads can run 
      without blocking if the write lock is free. This increases performance for read only operations. 

      The Student2 is the complete code that you should try to run:

 */

 