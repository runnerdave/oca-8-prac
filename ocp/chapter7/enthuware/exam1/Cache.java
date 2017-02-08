



import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
public class Cache {
    
    static ConcurrentHashMap<String, Object> chm = new ConcurrentHashMap<String, Object>();
    
    public static void main(String[] args) {
        chm.put("a", "aaa");
        chm.put("b", "bbb");
        chm.put("c", "ccc");
        
        new Thread(){
            public void run(){
                Iterator<Entry<String, Object>> it = Cache.chm.entrySet().iterator();
                while(it.hasNext()){
                    Entry<String, Object> en = it.next();
                    if(en.getKey().equals("a") || en.getKey().equals("b")){
                        it.remove();
                    }
                }
            }
        }.start();
        
        new Thread(){
            public void run(){
                Iterator<Entry<String, Object>> it = Cache.chm.entrySet().iterator();
                while(it.hasNext()){
                    Entry<String, Object> en = it.next();
                    System.out.print(en.getKey()+", ");
                }
            }
        }.start();        
    }
}

/**
* Which of the following are possible outputs when the above program is run?
*
* a. It may print any combination of the keys.
* b.  It may print any combination except: c, 
* c. It may print any combination except: a, or b, or a, b, or b, a
* d. It may print any combination except: b, c,
* e. It may print any combination except: a, b,
* 
* Answer c:
* This is correct because the order of iteration is not known and so the thread that 
* removes "a" and "b", may remove them in any order. Thus, the iterator thread may or may 
* not see "a" and/or "b" through its Iterator. However, "c" is never removed from the map 
* and so c, will always be printed.
* 
* Explanation:
* An important thing to know about the Iterators retrieved from a ConcurrentHashMap 
* is that they are backed by that ConcurrentHashMap, which means any operations done on 
* the ConcurrentHashMap instance may be reflected in the Iterator.
*
* Thus, in this case, the thread that is iterating through the entries may or may not see 
* the entries removed from the map by another thread. The following is what JavaDoc API 
* description says about ConcurrentHashMap:
*
* Retrieval operations (including get) generally do not block, so may overlap with update 
* operations (including put and remove). Retrievals reflect the results of the most recently 
* completed update operations holding upon their onset. For aggregate operations such as 
* putAll and clear, concurrent retrievals may reflect insertion or removal of only some 
* entries. Similarly, Iterators and Enumerations return elements reflecting the state of 
* the hash table at some point at or since the creation of the iterator/enumeration. 
* They do not throw ConcurrentModificationException. However, iterators are designed 
* to be used by only one thread at a time.
*
* and the following is the behaviour description of the EntrySet retrieved from a 
* ConcurrentHashMap instance using the entrySet() method:
*
* entrySet() returns a Set view of the mappings contained in this map. The set is backed by 
* the map, so changes to the map are reflected in the set, and vice-versa. The set supports 
* element removal, which removes the corresponding mapping from the map, via the 
* Iterator.remove, Set.remove, removeAll, retainAll, and clear operations. 
* It does not support the add or addAll operations.
* 
* The view's iterator is a "weakly consistent" iterator that will never throw 
* ConcurrentModificationException, and guarantees to traverse elements as they existed 
* upon construction of the iterator, and may (but is not guaranteed to) reflect any 
* modifications subsequent to construction.
**/