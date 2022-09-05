package t05_control_method;

public class JoinExample {

	public static void main(String[] args) {
		System.out.println("MAIN 시작");
		Thread t1 = new Thread(new Runnable() {
			private int sum;
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				for(int i=0; i<=100; i++) {
					sum += i;
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {}
					System.out.println(name+" sum : " + sum);
				}
				System.out.println(name+" 종료");
			}
		});
		t1.setName("SumThread");
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {}
		
		System.out.println("MAIN 종료");
	}

}



