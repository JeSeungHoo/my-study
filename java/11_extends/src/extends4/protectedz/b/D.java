package extends4.protectedz.b;

import extends4.protectedz.a.A;

public class D extends A {
	
	A a = new A();
	D(){
		// a.a = 100;
		super.a = 100;
		methodA();
	}
	
	

	@Override
	public void methodA() {
		System.out.println("D class의 methodA");
	}
	
	// protected void methodB() {}



	public static void main(String[] args) {
		System.out.println("");
	}

}







