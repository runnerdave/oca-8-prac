

import java.util.*;
class Book {
    private String isbn;
    public Book(String isbn){ this.isbn = isbn; }
    
    public boolean equals(Object o){
        return (o instanceof Book && ((Book)o).isbn.equals(this.isbn));
    }
    // ... setters and getters

    /*my stuff
    @Override
    public String toString() {
        return isbn;
    }

    @Override
    public int hashCode() {
        return isbn.length();
    }
    */
}

class BookStore {
    Map<Book, Integer> map = new HashMap<Book, Integer>();    
  
    public BookStore(){
        Book b = new Book("A111");
        map.put(b, 10);
        b = new Book("B222");
        map.put(b, 5);
    }
    
    Integer getNumberOfCopies(Book b){
        return map.get(b);
    }

    public static void main(String[] args){
        BookStore bs = new BookStore();
        Book b = new Book("A111");
        System.out.println(bs.getNumberOfCopies(b));  //1

        //my stuff
        System.out.println("b hashcode:" + b.hashCode());
        System.out.println("the other hashcodes:");
        bs.map.forEach((k,v) -> {
                    System.out.println("Book isbn:" + k + " - hashcode:" + k.hashCode());
        });


    }
    
}

/* What can be done so that it will print 10 at  line //1?
*
* a. Remove the equals() method from Book class.
* This will not help because two different Book objects will never be considered 
* equal and map won't return the value associated with Book with isbn of A111.
* 
* b. Add the following hashCode method to Book: 
*    public int hashCode(){ return super.hashCode(); }
* You might as well not implement a hashCode method because this is just calling 
* super.hashCode(), which is already available in this class through inheritance. 
* FYI, this technique is used with the clone() method, which is protected in Object class, 
* if you want your class to have a public clone() method.
* 
* c. Add the following hashCode method to Book: 
*    public int hashCode(){ return 100; }
* While being a very inefficient, this is valid because it ensures 
* that two equal Book objects have same hashcode value.
* 
* d. Nothing needs to be done.
* As such, the hash code of the Book object with isbn of A111 that exists in map is 
* different from the new Book object created in main() method. So map.get() may not find it. 
* Thus, it will return null.
* 
* Remember that, before comparing the objects with equals() method, a map first tries 
* to locate the bucket in which it thinks it will find the object. It locates the bucket 
* using hash code of the key object passed in get(key) or put(key, object).
* 
* Now, if you do not implement the hash code, object class's hashcode will be used. 
* So when you put the original Book object, its hash code will be different from the 
* book object that you pass in get(book). Thus, it will not find the right bucket and so 
* it will not be able to find the original book object.
*
* e. Use TreeMap instead of HashMap.
* This will not help because it does not solve the basic problem of bad hashCode() 
* method that exists with Book class. Moreover, if TreeMap is used, the map.put() 
* call will throw a ClassCastException because Book does not implement Comparable interface.
*
* Explanation:
* A Map is nothing but a set of buckets holding key-value pairs. 
* Each bucket corresponds to a unique hashcode. When you store a key-value pair in a Map, 
* the following things happen:
*
* 1. Hashcode of the key is computed. This key is used to identify the bucket 
*    where the key-value must be stored.
* 2. The key - value pair is stored in that bucket wrapped in a Map.Entry object.
* 3. If multiple keys have same hashcode value, all those key-value pairs are 
*    stored in the same bucket.
*
* Now, a look up in a Map is a three step process:
* 
* 1. Hashcode of the key is computed. This code is used to identify the bucket where the 
*    key should be looked for.
* 2. For all the key-value pairs in that bucket, check whether the supplied key is equal to 
*    the key in the bucket using equals() method.
* 3. If a match exists, return the value, otherwise, return null.
* 
* As you can see, it is critically important to make sure that hashCode() method 
* return the same value for two objects that are equal as per equals() method. 
* If this rule is not followed, you will not be able to retrieve the value from the 
* map using another key object that is equal to the key object stored in the map.
*
* This is what is happening with the given code. Even though the Book object is 
* equal to the Book object in the map, its hash code is different. So map looks 
* for a matching key-value in a different bucket. Obviously, it will not find any 
* matching Book object there.
*
* If you return the same hash code value for all the objects, as in option 3, 
* all the key-value pairs will be kept in the same bucket. Thus, a match will be 
* found even though it will require to call equals() on all the objects.
*/
