
public class VariableTest {
	
	public static void main(String[] args) {
		//선언부
		int num;
		// 초기화 전 사용 불가 컴파일 오류
		// System.out.println(num);
		//   초기화
		num = 10;
		//num = "문자열"; // 정수값만 저장가능
		
		// 0B 바이너리  - 뒤에 오는 값은 이진수
		byte bNum = 0B00001010;
		System.out.println("bNum : "+bNum);
		// 0 이 붙으면 8진수
		//           8^1 * 1 + 2
		byte oNum = 012;
		System.out.println("oNum : "+oNum);
		// 0X <-- 대문자 X 
		// 16진수 로 표현
		byte xNum = 0X3A;
		System.out.println("xNum : "+xNum);
		
		byte b1 = -128;
		b1 = 127;
		// b1 = -129; // 컴파일 오류
		
		char c = '가';
		//c = 'AB'; // 컴파일 오류
		c = 65;
		System.out.println("c : " + c);
		c = 'A';
		c = (char)(c + 1);
		System.out.println("c : " + c);
		// c = -1; // 컴파일 오류
		// 2byte의 정수를 저장하고 양수 음수를 표현
		short s =  -30000; 
		// 4byte의 정수를 저장 
		int i = 1000000000;
		
		long l = 100000000000l;
		
		// 십진법 수 : decimal
		// float 4byte - 소수점 7자리
		float f = 3.145f;
		f = (float)3.145;
		// double 8byte - 소수점 15자리 - 실수형 기본 리터럴
		double d = 3.141592;
		double sum = f + d;
		
		sum = i+d;
		System.out.println(sum);
		// 1.000000003141592E9
		
		// 지수 표기법
		System.out.println(3e+5 == 300000);
		System.out.println(3e-5 == 0.00003);
		
		boolean isTrue = 3e-5 == 0.00003;
		System.out.println(isTrue);
		
		
		String str = "문자열을 저장하는 녀석";
		System.out.println(str);
		
	}
	
}






