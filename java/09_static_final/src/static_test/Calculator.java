package static_test;

public class Calculator {
	
	int a, b;
	
	static int result;
	
	int sum() {
		return a + b;
	}
	
	static int plus(int x, int y) {
		//a = x + y;
		return x + y;
	}

	public static void main(String[] args) {
		// Calculator.sum();
		int sum = Calculator.plus(10, 20);
		Calculator calc = new Calculator();
		sum = calc.sum();
		// a = 10;
		result = plus(100, 200);
	}

}



