package a.base;

public class RemoteControlExam {

	public static void main(String[] args) {
		RemoteControl tvRemote;// = new RemoteControl();
		tvRemote = new TVRemoteControl();
		tvRemote = new AirRemoteControl();
		tvRemote.turnOn();
		tvRemote.setValue(11);
		tvRemote.turnOff();
		
		System.out.println(RemoteControl.MAX_VALUE);
		System.out.println(RemoteControl.MIN_VALUE);
		//RemoteControl.MIN_VALUE = 10;
		
		RemoteControl smartTVReote
								= new SmartTVRemoteControl();
		smartTVReote.turnOn();
//		smartTVReote.search("안된다");
		smartTVReote.setValue(8);
		
		Searchable searchRemote = (Searchable)smartTVReote;
		searchRemote.search("닥터 스트레인지 대혼돈의 멀티버스");
		if(searchRemote instanceof SmartTVRemoteControl) {
			SmartTVRemoteControl stc 
				= (SmartTVRemoteControl)searchRemote;
			System.out.println(Searchable.MAX_VALUE);
			stc.search("닥터스트레인지2");
		}
	}

}











