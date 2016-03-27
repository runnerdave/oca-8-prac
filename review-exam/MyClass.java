class MyClass
 {
   void myMethod(int i) {System.out.println(i);}
   void myMethod(String s) {System.out.println("String version");}
   void myCharValue(String i) {System.out.println(Character.codePointAt(i,0));}
   void myCharDigitValue(int i) {System.out.println(Character.digit(i,10));}
   void myAsciiCharValue(char c) {System.out.println((int)c);}
   public static void main(String args[])
   {
       MyClass obj = new MyClass();
       char ch = '0';
       obj.myMethod(ch);
       obj.myCharValue("a");
       obj.myCharDigitValue(97);
       obj.myAsciiCharValue('a');
  }
 }
