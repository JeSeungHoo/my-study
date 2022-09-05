
public class Operator00ArithmeticTest {
	
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		// 양의 정수 표현 - 없는 것과 동일
		System.out.println(+num1);
		// 음의 정수 표현
		System.out.println(-num2);
		System.out.println(num2);
		num2 = -num2;
		System.out.println(num2);
		
		num1 = 10;
		num2 = 3;
		int result = num1 / num2;
		System.out.println("result : "+result);
		
		double dResult = num1 / num2;
		System.out.println("dResult : "+dResult);
		
		double typeResult = num1 / dResult;
		System.out.println("typeResult : "+typeResult);
		
		String s = "최기근";
		s = num1 + num2 + s;
		System.out.println(s);
		s = s + (num1 + num2);
		System.out.println(s);
		
		int a = 1, b = 1;
		int c = a++;
		System.out.println("c : " + c);
		System.out.println("a : " + a);
		c = ++a;
		System.out.println("c : " + c);
		System.out.println("a : " + a);
		
	}
}







