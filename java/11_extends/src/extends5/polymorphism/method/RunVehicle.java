package extends5.polymorphism.method;

class Vehicle{
	public void run() {
		System.out.println("탈것이 달립니다.");
	}
}

class Texi extends Vehicle{
	public void run() {
		System.out.println("택시가 승객을 모시고 달립니다.");
	}
}

class Bus extends Vehicle{
	public void run() {
		System.out.println("버스가 승객을 태우고 달립니다.");
	}
}

class MotorCycle extends Vehicle{
	public void run() {
		System.out.println("오토바이가 두바퀴로 달립니다.");
	}
}

public class RunVehicle {
	
	public static void runTexi(Texi texi) {
		texi.run();
	}
	public static void runBus(Bus bus) {
		bus.run();
	}
	
	public static void runVehicle(Vehicle vehicle) {
		vehicle.run();
	}

	public static void main(String[] args) {
		Texi texi = new Texi();
		runTexi(texi);
		Bus bus = new Bus();
		runBus(bus);
		runVehicle(bus);
		runVehicle(texi);
		runVehicle(new MotorCycle());
	}

}






