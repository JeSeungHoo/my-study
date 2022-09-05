package t03_state;

public class StatePrintThread extends Thread {
	
	Thread targetThread;
	
	StatePrintThread(Thread targetThread){
		this.targetThread=targetThread;
	}
	
	public void run() {
		while(true) {
			Thread.State state = targetThread.getState();
			System.out.println("target state : " + state);
			if(state == Thread.State.NEW) {
				targetThread.start();
			}
			if(state == Thread.State.TERMINATED) {
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}

}













