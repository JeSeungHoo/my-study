package extends6.abstracts;

public class AICar extends Car{

	@Override
	public void drive() {
		System.out.println("자율 주행 합니다.");
		System.out.println("지정된 경로로 방향을 바꿉니다.");
	}

	@Override
	public void stop() {
		System.out.println("목적지에 스스로 멈춥니다.");
	}

}







