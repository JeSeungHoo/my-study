package e.reference;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car();
		System.out.println(car.company);
		System.out.println(car.model);
		System.out.println(car.maxSpeed);
		System.out.println(car.engine);
		
		car.company = "현대자동차";
		car.model = "싼타페";
		car.maxSpeed = 380;
		
		Engine engine = new Engine();
		car.engine = engine;
		
		System.out.println(engine == car.engine);
		car.engine.rpm = 2000;
		System.out.println(engine.rpm);
		
		Car car2 = new Car();
		car2.company = "KIN";
		car2.model = "모닝";
		car2.engine = new Engine();
		car2.engine = engine;
		System.out.println(car2.engine.rpm);
	}

}









