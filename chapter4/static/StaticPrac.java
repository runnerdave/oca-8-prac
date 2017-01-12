public class StaticPrac {
    public static void main(String... args) {
        MyStaticTest m1 = new MyStaticTest();
        MyStaticTest m2 = new MyStaticTest();

        System.out.println("m1 val1:" + m1.val1);
        System.out.println("m2 val1:" + m2.val1);

        System.out.println("m1 val2:" + m1.val2);
        System.out.println("m2 val2:" + m2.val2);
        m1.val2 = 3;
        System.out.println("m1 val2:" + m1.val2);
        System.out.println("m2 val2:" + m2.val2);
        m1.val1 = 4;
        System.out.println("m1 val1:" + m1.val1);
        System.out.println("m2 val1:" + m2.val1);
    }
}

class MyStaticTest {
    static int val1 = 1;
    int val2 = 2;
}