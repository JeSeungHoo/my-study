package generic02_multi;

public class TwinExample {
	public static void main(String[] args) {
		Twin<TV,String> twin = new Twin<TV,String>();
		TV tv = new TV();
		twin.setType(tv);
		twin.setModel("LG 스마트 TV");
		System.out.println(twin.getModel());
		
		Twin<Car, Integer> car = new Twin<>();
		Car car1 = new Car();
		car.setType(car1);
		car.setModel(520);
	}
}







