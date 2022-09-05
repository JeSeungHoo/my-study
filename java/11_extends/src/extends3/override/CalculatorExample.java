package extends3.override;

public class CalculatorExample {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		double area = calc.circleArea(5);
		System.out.println(area);
		
		Computer com = new Computer();
		area = com.circleArea(5);
		System.out.println(area);
	}

}








