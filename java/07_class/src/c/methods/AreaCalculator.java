package c.methods;

public class AreaCalculator {
	// 사각형의 넓이를 계산
	
	// 정사각형의 넓이를 계산
	int areaRectangle(int x) {
		return x * x;
	}
	// 직사각형 , 정사각형의 넓이
	int areaRectangle(int x, int y) {
		return x * y;
	}
	// 정밀도 향상
	double areaRectangle(double x, double y) {
		return x * y;
	}
	
	// num1 / num2 연산 후 결과를 출력
	void divide(double num1, int num2) {
		if(num2 == 0) {
			System.out.println("나누는 수는 0이 될 수 없습니다.");
			return;
		}
		double result = num1 / num2;
		System.out.printf("%.1f / %d = %.1f",num1,num2,result);
	}
	
	public static void main(String[] args) {
		AreaCalculator c = new AreaCalculator();
		int result = c.areaRectangle(10);
		int result1 = c.areaRectangle(10, 20);
		double result2 = c.areaRectangle(10.3, 10.3);
		System.out.println(result);
		System.out.println(result1);
		System.out.println(result2);
		
		c.divide(10, 0);
		//System.out.println(10/0);
	}
}






