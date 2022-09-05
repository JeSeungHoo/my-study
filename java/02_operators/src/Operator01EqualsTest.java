
public class Operator01EqualsTest {
	
	public static void main(String[] args) {
		// 비교 연산자 or 관계 연산자
		// > , >= , < , <= 좌우변의 값을 비교
		// 동등 비교연산자
		// ==  ,  !=
		// true , false
		
		int num1 = 10, num2 = 20;
		boolean result = num1 > num2;
		System.out.println(result);
		result = num1 == num2;
		System.out.println(result);
		
		String s = "최기근";
		String s1 = "최기근";
		String s2 = "잠자는 김박사";
		System.out.println(s == s1);
		System.out.println(s == s2);
		
		String s3 = new String("최기근");
		System.out.println(s);
		System.out.println(s3);
		System.out.println(s == s3);
		result = s.equals(s3);
		System.out.println(result);
	}
	
}




