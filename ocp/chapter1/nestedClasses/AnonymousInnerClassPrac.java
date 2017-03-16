
interface MyInterface {
    void printSomething();
}

interface MyInterfaceII {
    String printSomethingWithArg(String str);
}

public class AnonymousInnerClassPrac {
    
    public static void main(String... args) {
        System.out.println("===Anonymous inner class example===");
        implementMyItf();
        System.out.println(implementMyItfII());
    }

    public static void implementMyItf() {
        MyInterface mif = new MyInterface() {
                                                public void printSomething() {
                                                    System.out.println("hello world");
                                                }
                                            };
        mif.printSomething();                                            
    }

    public static String implementMyItfII() {
        MyInterfaceII mifII = new MyInterfaceII() {
                                                    public String printSomethingWithArg(String str) {
                                                        return "Hello: " + str;
                                                    }
                                                  };
        return mifII.printSomethingWithArg("hello world with arg");
    }
}