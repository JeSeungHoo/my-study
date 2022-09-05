package extends1.base;

class Car{
	String company = "기아자동차";
	int maxSpeed;
	
	Car(){
		System.out.println("Car 기본생성자");
	}
	
	Car(String company){
		this.company = company;
		System.out.println("값을 넘겨받는 Car의 생성자");
	}
	
	public String toString() {
		return "Car[ company : "+company+"]";
	}
}

class Texi extends Car{
	Texi(){
//		super();
		System.out.println("texi의 기본생성자");
	}
}

class Bus extends Car{
	
	Bus(){
		super("HYUNDAI");
		System.out.println("버스의 기본 생성자");
	}
}


public class CarExample {

	public static void main(String[] args) {
		Texi texi = new Texi();
		System.out.println(texi.toString());
		Bus bus = new Bus();
		bus.maxSpeed = 200;
		String str = bus.toString();
		System.out.println(str);
	}

}












