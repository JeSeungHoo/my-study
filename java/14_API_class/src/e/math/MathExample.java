package e.math;

public class MathExample {

	public static void main(String[] args) {
		// Math (수학관련 처리 class)
		// 절대값을 알려주는 abs 함수
		int v1 = Math.abs(-5);
		double v2 = Math.abs(-3.14);
		System.out.println("v1 : " + v1);
		System.out.println("v2 : " + v2);
		
		// 내림
		double v3 = Math.floor(5.3);
		double v4 = Math.floor(-5.3);
		System.out.println("v3 : " + v3);
		System.out.println("v4 : " + v4);
		
		// 올림 ceil
		double v5 = Math.ceil(5.3);
		double v6 = Math.ceil(-5.3);
		System.out.println("v5 : "+v5);
		System.out.println("v6 : "+v6);
		
		// 두개의 값을 매개변수로 넘겨받아 둘중 큰수를 반환
		int v7 = Math.max(10, 12);
		double v8 = Math.max(10.1, 10.4);
		System.out.println("v7 : " + v7);
		System.out.println("v8 : " + v8);
		
		// 두개의 값을 매개변수로 넘겨받아 둘중 작은 수를 반환
		int v9 = Math.min(10, 7);
		double v10 = Math.min(10.5, 10.3);
		System.out.println("v9 : " + v9);
		System.out.println("v10 : " + v10);
		
		// 반올림
		// 소수점 첫째자리에서 반올림하고
		// 값을 double type으로 반환 rint
		double v11 = Math.rint(5.311);
		double v12 = Math.rint(5.611);
		System.out.println("v11 : " + v11);
		System.out.println("v12 : " + v12);
		
		// 반올림 하고 나서  long 타입으로 값을 반환
		long v13 = Math.round(5.451352);
		System.out.println("v13 : " + v13);
		
		// 0 <= random < 1.0
		double random = Math.random();
		System.out.println(random);
		
		// 거듭 제곱
		// pow(a,b)
		// a와 b에 대한 제곱 연산
		// pow(2,10) 2의 10승
		double v14 = Math.pow(2, 10);
		System.out.println("v14 : " + v14);
		
		// 넘겨받은 매개변수의 제곱근을 구함.
		// 16의 제곱근 4 sqrt
		double v15 = Math.sqrt(9);
		System.out.println("v15 : " +v15);
		
		// 두수의 차이를 반환
		// substractExact
		System.out.println(Math.subtractExact(11, -5));
	}

}




