package c.methods;
// 객체의 동작-기능들을 정의
public class Methods {
	
//	반환형 메소드이름_식별자(매개변수들...){실행블럭}	
	void methodA() {
		System.out.println("반환하는 값은 없고 기능만 수행");
	}
	
	int methodB() {
		System.out.println("int type의 값을 반환");
		return 0;
	}
	
	double methodC(int x, int y) {
		System.out.println("매개변수에 인자값 두개를 전달받아");
		System.out.println("블럭 실행 후 double type의 데이터 반환");
		return x / y;
	}
	
	double avg(int x, int y, int z) {
		int total = x+y+z;
		return total / 3;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Methods");
		Methods m = new Methods();
		m.methodA();
		int resultB = m.methodB();
		System.out.println(resultB);
		
		double avg = m.avg(10, 20, 30);
		System.out.println(avg);
	}

}




