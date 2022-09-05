package extends4.protectedz.b;

import extends4.protectedz.a.A;

public class C// extends B
{
	
	A a = new A();
	
	C(){
//		a.a = 100;	// 다른 패키지의 자식클래스를 제외하고는 접근불가
//		a.methodA();
		a.b = 100;
	}
}








