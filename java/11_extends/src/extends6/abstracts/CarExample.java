package extends6.abstracts;

public class CarExample {

	public static void main(String[] args) {
		Car aiCar = new AICar();
		aiCar.run();
		
		System.out.println("==================");
		Car manualCar = new ManualCar();
		manualCar.run();
	}

}








