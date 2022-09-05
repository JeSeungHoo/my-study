package t06_daemon;

public class ParentThread extends Thread {
	
	private ChildThread thread;

	public ParentThread(ChildThread thread) {
		this.thread = thread;
	}
	
	@Override
	public void run() {
		thread.setDaemon(true);
		thread.start();
		for(int i=0; i<5; i++) {
			System.out.println(getName()+" "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
		System.out.println("Parent Thread 종료");
	}
	
}







