package extends2.phone;

public class DMBPhone extends Phone{
	
	int channel;
	
	public DMBPhone() {}

	// alt + s + a
	public DMBPhone(String model, String color, int channel) {
		super(model, color);
		/*
		super.model = model;
		this.color = color;
		*/
		this.channel = channel;
	}
	
	void turnOnDMB() {
		System.out.println("DMB를 켭니다.");
	}
	
	void turnOff() {
		System.out.println("DMB를 끕니다.");
	}
	
	void changeChannel(int channel) {
		this.channel = channel;
		System.out.println("채널이 "+this.channel+"로 변경되었습니다.");
	}
	
}












