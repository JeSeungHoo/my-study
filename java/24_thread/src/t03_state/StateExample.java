package t03_state;

public class StateExample {

	public static void main(String[] args) {
		
		// NEW
		TargetThread targetThread = new TargetThread();
		
		Thread print = new StatePrintThread(targetThread);
		print.start();
		System.out.println("MAIN 종료");
	}

}










