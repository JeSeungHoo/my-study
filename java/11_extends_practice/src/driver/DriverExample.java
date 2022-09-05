package driver;

public class DriverExample {
	
	public static void drive(Driver driver) {
		driver.drive();
	}

	public static void main(String[] args) {
		Driver busDriver = new BusDriver();
		busDriver.name = "김유신";
		drive(busDriver);
		
		Driver texiDriver = new TexiDriver();
		texiDriver.name = "심현석";
		drive(texiDriver);
		
	}

}
