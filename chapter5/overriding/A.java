
//yet another coviariant example 
class A{ }
class B extends A{ }
class C extends B{ }

class X{
   B getB(){ return new B(); }
}

class Y extends X{
  //method declaration here
}

//Which of the following methods can be inserted in class Y? (choose two)
//	public C getB(){ return new B(); }
//  protected B getB(){ return new C(); }
//  C getB(){ return new C(); }
//  A getB(){ return new A(); }