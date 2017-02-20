
/*q12: Identify the correct statements about the following code:*/

import java.util.*;
class Account {
    private String id;
    public Account(String id){ this.id = id; }
    //accessors not shown
}
public class BankAccount extends Account{
    private double balance;
    public BankAccount(String id, double balance){ super(id); this.balance = balance;}

    //accessors not shown

    public static void main(String[] args) {
        Map<String, Account> myAccts = new HashMap<>();
        myAccts.put("111", new Account("111"));
        myAccts.put("222", new BankAccount("111", 200.0));
        
        BiFunction<String, Account, Account> bif =
  (a1, a2)-> a2 instanceof BankAccount?new BankAccount(a1, 300.0):new Account(a1); //1
        
        myAccts.computeIfPresent("222", bif);//2
        BankAccount ba = (BankAccount) myAccts.get("222");
        System.out.println(ba.getBalance());
    }
}

/*
A. It will not compile due to code at //1.
B. It will not compile due to code at //2.
C. It will print 200.0
D. It will print 300.0

Answer D:
Since myAccts map does contain a key "222", computeIfPresent method will execute the function and replace the existing value associated with the given key 
in the map with the new value returned by the function.  The given function returns a new BankAccount object with a balance of 300.0.

Explanation:
Here are a few points that you should know about java.util.BiFunction - 
1. It is a function that accepts two arguments and produces a result. 
2. The types of the arguments and the return value can all be different.  

You also need to know about the three flavors of compute methods of Map: 
1. public V compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction) 
Attempts to compute a mapping for the specified key and its current mapped value (or null if there is no current mapping). 
For example, to either create or append a String msg to a value mapping: map.compute(key, (k, v) -> (v == null) ? msg : v.concat(msg)) 
(Method merge() is often simpler to use for such purposes.) If the function returns null, the mapping is removed (or remains absent if initially absent). 
If the function itself throws an (unchecked) exception, the exception is rethrown, and the current mapping is left unchanged. 
Parameters: key - key with which the specified value is to be associated remappingFunction - the function to compute a value 
Returns: the new value associated with the specified key, or null if none   

2. public V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction) 
If the specified key is not already associated with a value (or is mapped to null), attempts to compute its value using the given mapping function 
and enters it into this map unless null. If the function returns null no mapping is recorded. If the function itself throws an (unchecked) exception, 
the exception is rethrown, and no mapping is recorded. The most common usage is to construct a new object serving as an initial mapped value or memorized result, 
as in:   map.computeIfAbsent(key, k -> new Value(f(k)));  Or to implement a multi-value map, Map<K,Collection<V>>, 
supporting multiple values per key:   map.computeIfAbsent(key, k -> new HashSet<V>()).add(v);  
Parameters: key - key with which the specified value is to be associated mappingFunction - the function to compute a value 
Returns: the current (existing or computed) value associated with the specified key, or null if the computed value is null   

3. public V computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction) If the value for the specified key is present and non-null, 
attempts to compute a new mapping given the key and its current mapped value. If the function returns null, the mapping is removed. 
If the function itself throws an (unchecked) exception, the exception is rethrown, and the current mapping is left unchanged. 
Parameters: key - key with which the specified value is to be associated remappingFunction - the function to compute a value 
Returns: the new value associated with the specified key, or null if none
*/