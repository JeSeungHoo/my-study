package extends3.override;

public class Computer extends Calculator{

	// alt + s + v
	@Override
	public double circleArea(double radius) {
		System.out.println("Computer에 존재하는 circleArea 호출");
		return radius * radius * 3.141592653589793;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	

}








