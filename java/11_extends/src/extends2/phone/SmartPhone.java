package extends2.phone;

public class SmartPhone extends DMBPhone{
	
	String url;
	
	public SmartPhone(String model, 
						String color, 
						int channel, 
						String url) {
		super(model, color, channel);
		this.url = url;
	}

	void turnOnInternet() {
		System.out.println("인터넷"+url+"을 켭니다.");
	}
	
	void turnOffInternet() {
		System.out.println("인터넷을 끕니다.");
	}
	
	void changeURL(String url) {
		this.url = url;
		System.out.println(url+"로 변경되었습니다.");
	}

}











