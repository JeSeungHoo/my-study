package t05_control_method.stop;

class PrintThread extends Thread{
	
	private boolean isRun = true;
	
	public void setIsRun(boolean isRun) {
		this.isRun = isRun;
	}
	
	@Override
	public void run() {
		while(isRun) {
			System.out.println("실행중");
		}
		System.out.println("자원정리");
		System.out.println("실행종료");
	}
}

public class StopFlagExample {

	public static void main(String[] args) {
		PrintThread t = new PrintThread();
		t.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		// t.stop();
		t.setIsRun(false);
	}
}






