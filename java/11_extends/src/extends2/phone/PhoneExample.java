package extends2.phone;

public class PhoneExample {

	public static void main(String[] args) {
		Phone phone = new Phone("걸리버","GOLD");
		phone.powerOn();
		phone.bell();
		phone.pickUp();
		phone.sendVoice("여보세요!");
		phone.receiveVoice("이번에 새로 나온 좋은 상품...");
		phone.sendVoice("괜찮습니다.");
		phone.hangUp();
		phone.powerOff();
		
		DMBPhone dmbPhone = new DMBPhone("가로본능", "SILVER", 11);
		System.out.println(dmbPhone.model);
		System.out.println(dmbPhone.color);
		dmbPhone.powerOn();
		dmbPhone.turnOnDMB();
		dmbPhone.changeChannel(8);
		dmbPhone.turnOff();
		dmbPhone.bell();
		dmbPhone.pickUp();
		dmbPhone.sendVoice("여보세요?");
		dmbPhone.receiveVoice("잘 지냈어? 나야...");
		dmbPhone.sendVoice("누구세요?");
		dmbPhone.receiveVoice("내 번호 지웠어???");
		dmbPhone.sendVoice("뚜..뚜...뚜..");
		dmbPhone.hangUp();
		dmbPhone.powerOff();
	}

}










