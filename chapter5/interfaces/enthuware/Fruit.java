
//What will the following code print when compiled and run?  

interface Eatable{
	int types = 10; 
} 

class Food implements Eatable {
	public static int types = 20; 
} 

public class Fruit extends Food implements Eatable{//LINE1
	public static void main(String[] args) {
		types = 30; //LINE 2
		System.out.println(types); //LINE 3 
	} 
}

/*
answer: compilation failure at line 2 and 3

explanation:
Class Fruits implements Eatable as well as extends Food. 
Since Eatable and Food both have a static int field name types, 
class Fruit has access to two fields by the same name.
Now, if you try to access the types field from Fruit without specifying 
which field to you really mean to access, the compiler will complain that types 
is ambiguous because both are equally applicable.
*/
