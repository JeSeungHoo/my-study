package d.contructor;

public class CarExample {

	public static void main(String[] args) {
		
		Car basic = new Car();
		basic.company = "HYUNDAI";
		basic.model = "캐스퍼";
		basic.color = "WHITE";
		basic.maxSpeed = 200;
		basic.speed = 10;
		System.out.println(basic.company);
		System.out.println(basic.model);
		System.out.println(basic.color);
		System.out.println(basic.maxSpeed);
		System.out.println(basic.speed);
		
		System.out.println("======================");
		Car myCar = new Car("Benz","s class","black");
		System.out.println(myCar.company);
		System.out.println(myCar.model);
		System.out.println(myCar.color);
		
		System.out.println("======================");
		Car yourCar = new Car("KIN", "K3", 0);
		yourCar.color = "red";
		System.out.println(yourCar.company);
		System.out.println(yourCar.model);
		System.out.println(yourCar.color);
		System.out.println(yourCar.speed);
		
		System.out.println("======================");
		Car masterCar = new Car("BMW","728d","black",300,0);
		System.out.println(masterCar.company);
		System.out.println(masterCar.model);
		System.out.println(masterCar.color);
		System.out.println(masterCar.maxSpeed);
		System.out.println(masterCar.speed);
		
	}

}






