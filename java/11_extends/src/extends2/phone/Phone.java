package extends2.phone;

// 1세대 일반 폰
public class Phone {
	String model;
	String color;
	
	public Phone(){}
	
	public Phone(String model, String color) {
		this.model = model;
		this.color = color;
	}
	
	public void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	public void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
	public void bell() {
		System.out.println("벨이 울립니다.");
	}
	
	public void pickUp() {
		System.out.println("전화를 받습니다.");
	}
	
	public void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
	
	public void sendVoice(String message) {
		System.out.println("본인 : " + message);
	}
	
	public void receiveVoice(String message) {
		System.out.println("상대방 : " + message);
	}
}













