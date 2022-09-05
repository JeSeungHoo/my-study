package d.contructor;

public class Car {
	
	String company;
	String model;
	String color;
	int maxSpeed;
	
	int speed;
	
	Car (){
		System.out.println("기본 생성자 호출");
	}
	
	Car (String c, String m, String cc){
		company = c;
		model = m;
		color = cc;
	}
	
	Car(String company, String model, int speed){
		this.company = company;
		this.model = model;
		this.speed = speed;
	}
	// alt + s + a
	public Car(String company, String model, String color, int maxSpeed, int speed) {
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.speed = speed;
	}
	

}





