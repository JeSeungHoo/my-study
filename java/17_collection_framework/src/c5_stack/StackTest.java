package c5_stack;

public class StackTest {

	public static void methodA() {
		System.out.println("methodA 호출");
		int result = methodB(5);
		System.out.println("result : "+result);
		System.out.println("methodA 종료");
	}
	
	public static int methodB(int b) {
		System.out.println("methodB 호출");
		int result = b * b;
		System.out.println("methodB 반환 종료");
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println("Main 시작");
		methodA();
		System.out.println("Main 종료");
	}
}


