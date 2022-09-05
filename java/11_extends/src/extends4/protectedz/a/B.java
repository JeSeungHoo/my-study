package extends4.protectedz.a;

public final class B {
	A a = new A();
	
	B(){
		a.a = 100;	// protected
		a.b = 100; 	// public
//		a.c = 100;	// private
		a.methodA();
	}
}










