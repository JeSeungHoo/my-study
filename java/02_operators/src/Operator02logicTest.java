
public class Operator02logicTest {
	
	public static void main(String[] args) {
		// 논리 연산자 : &&, || , ^ , !
		// |  ==  shift + \
		int num1 = 5;
		int num2 = 10;
		// && 논리 곱
		// 좌변 우변 둘다 true(참) 일때만 참
		// 둘중에 하나라도 거짓이면 false(거짓)
		boolean result = (num1 < 0) && (num2++ > 0);
		System.out.println(result);
		System.out.println(num1+" : "+num2);
		
		// || 논리합
		// 둘중에 하나라도 참(true)이면 참.
		// 둘다 거짓(false)일때 거짓
		num1 = 0;
		num2 = 0;
		result = (++num1 > 0) || (num2++ > 0);
		System.out.println("result : " + result);
		System.out.println(num1+" : "+ num2);
		
		System.out.println("result : " + !result);
	}
	
}




