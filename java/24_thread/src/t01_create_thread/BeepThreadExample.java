package t01_create_thread;

public class BeepThreadExample {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		Thread t = new BeepThread();
		t.start();//새로운 작업 스레드 생성

		Runnable run = new PrintTask();
		Thread t1 = new Thread(run);
		t1.start();
		
		for(int i=0; i<5; i++) {
			System.out.println("띵!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		
		Runnable workTask = new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<5; i++) {
					System.out.println("t2");
				}
			}
		};
		
		
		System.out.println("Main 종료");
	}	
}









